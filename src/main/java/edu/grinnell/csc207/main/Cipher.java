/**
 * @author: Yash Malik
 *  This program is meant to be run with 4 arguments.
 * -encode or -decode decides if message must be encoded or decoded. (you can also use -e or -d)
 * -vigenere or -caeser decides which algorithm to encode/decode with. (you can also use -v or -c)
 * CaeserCipher key must be a character.
 * all inputs must be lowercase.
 * Made for CSC207 2024 Fa.
*/
package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * This class contains the code to comprehend if user is trying to Encrypt or Decrypt a message
 * And which algorithm i.e. Caeser Cipher or Vigenere Cipher algorithm.
*/
public class Cipher {
  /**
   * The number of arguments to check for.
  */
  private static final int EXPECTED_NUM_ARGS = 4;

  /**
   * @param args - an array of the arguments that this function is called with.
  */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String inputString = "";
    String keyString = "";

    String cipherType = "";
    String objectiveType = "";

    if (args.length > EXPECTED_NUM_ARGS) {
      System.err.println("Error: There must only be 4 inputs.");
    } else {
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
          if (keyChar < 'a' || keyChar > 'z') {
            System.err.println("Error: Key must be a lowercase letter between 'a' and 'z'.");
            return; // Terminate program if error detected.
          } else {
            int key = keyChar;
            keyChar = CipherUtils.int2letter(key);
          } // Checks to make sure key entered in case of CaeserCipher is a lowercase letter.
          if (keyString.length() != 1) {
            System.err.println("Error: Caeser Cipher must have a single character as key.");
          } else { // Checks to make sure key entered in case of CaeserCipher is a char.
            if (objectiveType == "Encode") {
              pen.print(CipherUtils.caesarEncrypt(inputString, keyChar));
            } else {
              pen.print(CipherUtils.caesarDecrypt(inputString, keyChar));
            } // Decides if we need to encode or decode.
          } // Checks to make sure key entered in case of CaeserCipher is a char.
        } else {
          if (!keyString.matches("[a-z]+") || !inputString.matches("[a-z]+")) {
            System.err.println("Error: All inputs must contain only lowercase letters.");
            return; // Stop execution on invalid key.
          } else {
            if (objectiveType == "Encode") {
              pen.print(CipherUtils.vigenereEncrypt(inputString, keyString));
            } else {
              pen.print(CipherUtils.vigenereDecrypt(inputString, keyString));
            } // Decides if we need to encode or decode.
          } // Ensures all inputs are lowercase.
        } // Decides which Cipher type is needed.
      } // Ensures atleast 4 inputs were given.
    } // Ensures atmost 4 inputs were given.
    pen.close();
  } // End of main function.
} // End of Cipher
