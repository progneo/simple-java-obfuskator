package org.alex.utils;

import java.io.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

import org.alex.modifier.*;
import org.alex.ui.ObfuscationPanel;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import static org.alex.ui.ObfuscationPanel.namesLengthField;

public class OutputUtil {
  private static JarOutputStream outputStream = null;
  public static Map<String, ClassNode> classes = new HashMap<>();
  public static Map<String, ClassNode> ToAdd = new HashMap<>();
  private static JarOutputStream finalOutputStream;

  public static int namesLength = 40;

  public static List<ClassModifier> modules() {
    List<ClassModifier> modifier = new ArrayList<>(List.of());
    namesLength = Integer.parseInt(namesLengthField.getText());
    modifier.clear();
    if (ObfuscationPanel.flowObfuscationCheckBox.isSelected()) {
      modifier.add(new ModifierFlow());
    }
    if (ObfuscationPanel.AccessCodeCheckBox.isSelected()) {
      modifier.add(new ModifierAccessCode());
    }
    if(ObfuscationPanel.BooleansCheckBox.isSelected()) {
      modifier.add(new ModifierBooleans());
    }

    return modifier;
  }

  public static void run(String input, String output) {
    JarFile jarFile = null;
    try {
      jarFile = new JarFile(input);
      finalOutputStream = new JarOutputStream(new FileOutputStream(output));
    } catch (IOException e) {
      e.printStackTrace();
    }
    JarFile finalJarFile = jarFile;
    jarFile.stream()
        .forEach(
            entry -> {
              try {
                if (entry.getName().endsWith(".class")) {
                  final ClassReader classReader =
                      new ClassReader(finalJarFile.getInputStream(entry));
                  final ClassNode classNode = new ClassNode();
                  classReader.accept(classNode, ClassReader.SKIP_DEBUG);
                  classes.put(classNode.name, classNode);
                } else if (!entry.isDirectory()) {
                  finalOutputStream.putNextEntry(new ZipEntry(entry.getName()));
                  finalOutputStream.write(toByteArray(finalJarFile.getInputStream(entry)));
                  finalOutputStream.closeEntry();
                }
              } catch (final Exception e) {
                e.printStackTrace();
              }
            });
    try {
      jarFile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      outputStream = new JarOutputStream(new FileOutputStream(output));

      parseInput(input);
      classes
          .values()
          .forEach(
              classNode -> {
                for (ClassModifier m : modules()) {
                  m.modify(classNode);
                }
              });
      classes.putAll(ToAdd);
      classes
          .values()
          .forEach(
              classNode -> {
                ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                try {
                  classNode.accept(classWriter);
                  final JarEntry jarEntry = new JarEntry(classNode.name.concat(".class"));
                  outputStream.putNextEntry(jarEntry);
                  outputStream.write(classWriter.toByteArray());
                } catch (final Exception e) {
                  e.printStackTrace();
                }
              });

      outputStream.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    ToAdd.clear();
    classes.clear();
    System.out.println("[Stopped] array size == " + modules().size());
  }

  private static void parseInput(String input) {
    JarFile jarFile = null;
    try {
      jarFile = new JarFile(input);
    } catch (IOException e) {
      e.printStackTrace();
    }
    JarFile finalJarFile = jarFile;
    jarFile.stream()
        .forEach(
            entry -> {
              try {
                if (entry.getName().endsWith(".class")) {
                  final ClassReader classReader;
                  classReader = new ClassReader(finalJarFile.getInputStream(entry));
                  final ClassNode classNode = new ClassNode();
                  classReader.accept(classNode, ClassReader.SKIP_DEBUG);
                  classes.put(classNode.name, classNode);
                } else if (!entry.isDirectory()) {
                  outputStream.putNextEntry(new ZipEntry(entry.getName()));
                  outputStream.write(toByteArray(finalJarFile.getInputStream(entry)));
                  outputStream.closeEntry();
                }
              } catch (final Exception e) {
                e.printStackTrace();
              }
            });
    try {
      jarFile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static byte[] toByteArray(InputStream inputStream) throws IOException {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final byte[] buffer = new byte[0xFFFF];
    int length;
    while ((length = inputStream.read(buffer)) != -1) {
      outputStream.write(buffer, 0, length);
    }
    outputStream.flush();
    return outputStream.toByteArray();
  }
}
