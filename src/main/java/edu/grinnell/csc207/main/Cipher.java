package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String inputString = "";
    String keyString = "";

    String cipherType = "";
    String objectiveType = "";

    for (int i = 0; i < args.length; i++) {
      if (args[i].startsWith("-c")) {
        cipherType = "Caeser";
        continue;
      }

      if (args[i].startsWith("-v")) {
        cipherType = "Vigenere";
        continue;
      }

      if (args[i].startsWith("-e")) {
        objectiveType = "Encode";
        continue;
      }

      if (args[i].startsWith("-d")) {
        objectiveType = "Decode";
        continue;
      }

      if (inputString == "") {
        inputString = args[i];
        continue;
      }

      if (keyString == "") {
        keyString = args[i];
        continue;
      }
    }

    if (inputString == "" || keyString == "" || cipherType == "" || objectiveType == "") {
      System.err.println("Error: There must be 4 inputs.");
    }

    else{
      if (cipherType == "Caeser") {
        char keyChar = keyString.charAt(0);
        
        if (keyChar >= 'a' && keyChar <= 'z') {
          int key = keyChar - 'a'; 
          keyChar = CipherUtils.int2letter(key);
        } 

        else {
          System.err.println("Error: Key must be a lowercase letter between 'a' and 'z'.");
        }

        if (keyString.length() != 1) {
          System.err.println("Error: Caeser Cipher must have a single character as key.");
        }

        if (objectiveType == "Encode") {
          pen.print(CipherUtils.caesarEncrypt(objectiveType, keyChar));
        }

        else{
          pen.print(CipherUtils.caesarDecrypt(cipherType, keyChar));
        }

      }

      else{
        if (objectiveType == "Encode") {
          pen.print(CipherUtils.vigenereEncrypt(inputString, keyString));
        }
        
        else{
          pen.print(CipherUtils.vigenereDecrypt(inputString, keyString));
        }
      }
    }

    pen.close();
  }
}
