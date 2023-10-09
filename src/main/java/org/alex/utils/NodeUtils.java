package org.alex.utils;

import org.objectweb.asm.tree.*;

public class NodeUtils {
  public static MethodNode getMethod(final ClassNode classNode, final String name) {
    for (final MethodNode method : classNode.methods) if (method.name.equals(name)) return method;
    return null;
  }
}
