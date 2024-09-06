package edu.grinnell.csc207.main;

import java.io.PrintWriter;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    for (int i = 0; i < args.length; i++) {
      pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    }

    for (int i = 0; i < args.length; i++) {
      if (args[i].startsWith("-c")) {
        // run caeserCipher
      }

      if (args[i].startsWith("-v")) {
        // run vigenereCipher
      }

      if (args[i].startsWith("-e")) {
        // run encode
      }

      if (args[i].startsWith("-d")) {
        // run decode
      }
    }
    pen.close();
    System.err.println("Error: Invalid parameters");
  }
}
