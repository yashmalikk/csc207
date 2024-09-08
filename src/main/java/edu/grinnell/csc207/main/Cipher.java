package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * This class contains the code to comprehend if user is trying to Encrypt or Decrypt a message
 * And which algorithm i.e. Caeser Cipher or Vigenere Cipher algorithm.
 */
public class Cipher {
  /**
   * @param args - an array of the arguments that this function is called with.
   */
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
      } // If any of the inputs begin with "-c", we assume the user wants to use Caeser Cipher.

      if (args[i].startsWith("-v")) {
        cipherType = "Vigenere";
        continue;
      } // If any of the inputs begin with "-v", we assume the user wants to use Vigenere Cipher.

      if (args[i].startsWith("-e")) {
        objectiveType = "Encode";
        continue;
      } // If any of the inputs begin with "-e", we assume the user wants to encode.

      if (args[i].startsWith("-d")) {
        objectiveType = "Decode";
        continue;
      } // If any of the inputs begin with "-d", we assume the user wants to decode.

      if (inputString == "") {
        inputString = args[i];
        continue;
      } // We assume string to be encrypted/decrypted is entered before key.

      if (keyString == "") {
        keyString = args[i];
        continue;
      } // Final variable left to populate.
    } // All required variables have been assigned.
    if (inputString == "" || keyString == "" || cipherType == "" || objectiveType == "") {
      System.err.println("Error: There must be 4 inputs.");
    } else {
      if (cipherType == "Caeser") {
        char keyChar = keyString.charAt(0);
        if (keyChar >= 'a' && keyChar <= 'z') {
          int key = keyChar - 'a';
          keyChar = CipherUtils.int2letter(key);
        } else {
          System.err.println("Error: Key must be a lowercase letter between 'a' and 'z'.");
        } // Checks to make sure key entered in case of CaeserCipher is a lowercase letter.
        if (keyString.length() != 1) {
          System.err.println("Error: Caeser Cipher must have a single character as key.");
        } // Checks to make sure key entered in case of CaeserCipher is a char.
        if (objectiveType == "Encode") {
          pen.print(CipherUtils.caesarEncrypt(objectiveType, keyChar));
        } else {
          pen.print(CipherUtils.caesarDecrypt(cipherType, keyChar));
        } // Decides if we need to encode or decode.
      } else {
        if (objectiveType == "Encode") {
          pen.print(CipherUtils.vigenereEncrypt(inputString, keyString));
        } else {
          pen.print(CipherUtils.vigenereDecrypt(inputString, keyString));
        } // Decides if we need to encode or decode.
      } // Decides which Cipher type is needed.
    } // Ensures 4 inputs were given.
    pen.println();
    pen.close();
  } // End of main function.
} // End of Cipher
