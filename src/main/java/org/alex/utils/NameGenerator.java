package org.alex.utils;

import java.util.Random;

public class NameGenerator {

  static boolean StringInt = false;

  public static String String(int i) {
    StringBuilder string = new StringBuilder();
    int i2 = 0;
    while (i >= i2) {
      if (StringInt) {
        string.append(new Random().nextInt(9000) + 20000);
      } else {
        string.append((char) (new Random().nextInt(9000) + 20000));
      }
      i2++;
    }
    return string.toString();
  }

  public static String name() {
    return "Name";
  }
}
