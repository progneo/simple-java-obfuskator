package org.alex.modifier;

import org.alex.utils.NameGenerator;
import org.alex.utils.NodeUtils;
import org.alex.utils.OutputUtil;
import org.alex.utils.Utils;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class ModifierBooleans implements ClassModifier {
	@Override
	public void modify(ClassNode classNode) {
		boolean used = false;
		String name = NameGenerator.name() + NameGenerator.String(OutputUtil.namesLength);
			String desc = "(II)I";
			int xor = RANDOM.nextInt();
			String fName = NameGenerator.String(OutputUtil.namesLength);
		for (MethodNode method : classNode.methods) {
			for (AbstractInsnNode insnNode : method.instructions.toArray()) {
				if(insnNode.getOpcode() == ICONST_0 || insnNode.getOpcode() == ICONST_1) {
					used = true;
					InsnList list = new InsnList();
					int k2 = RANDOM.nextInt();
					list.add(new LdcInsnNode(Utils.getInt(insnNode) ^ (xor ^ k2)));
					list.add(new LdcInsnNode(k2));
					list.add(new MethodInsnNode(INVOKESTATIC, classNode.name, name, desc));
					method.instructions.insert(insnNode, list);
					method.instructions.remove(insnNode);
				}
			}
		}
		if(used) {
			MethodVisitor mv = classNode.visitMethod(ACC_PUBLIC | ACC_STATIC, name, desc, null, null);
			mv.visitCode();
			mv.visitVarInsn(ILOAD, 0);
			mv.visitFieldInsn(GETSTATIC, classNode.name, fName, "I");
			mv.visitVarInsn(ILOAD, 1);
			mv.visitInsn(IXOR);
			mv.visitInsn(IXOR);
			mv.visitInsn(IRETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
			classNode.fields.add(new FieldNode(ACC_STATIC, fName, "I", null, null));
			MethodNode clInit = NodeUtils.getMethod(classNode, "<clinit>");
			if (clInit == null) {
				clInit = new MethodNode(Opcodes.ACC_STATIC, "<clinit>", "()V", null, new String[0]);
				classNode.methods.add(clInit);
			}
			if (clInit.instructions == null)
				clInit.instructions = new InsnList();

			InsnList instructions = new InsnList();
			int key = RANDOM.nextInt();
			instructions.add(new LdcInsnNode(xor ^ key));
			instructions.add(new LdcInsnNode(key));
			instructions.add(new InsnNode(IXOR));
			instructions.add(new FieldInsnNode(PUTSTATIC, classNode.name, fName, "I"));

			if (clInit.instructions == null || clInit.instructions.getFirst() == null) {
                assert clInit.instructions != null;
                clInit.instructions.add(instructions);
				clInit.instructions.add(new InsnNode(Opcodes.RETURN));
			} else {
				clInit.instructions.insertBefore(clInit.instructions.getFirst(), instructions);
			}
		}
	}
}
