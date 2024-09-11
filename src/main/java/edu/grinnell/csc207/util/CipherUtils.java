/**
 * @author: Yash Malik.
 * This file contains all dependencies for Cipher.java and AllCaeser.java.
 * Made for CSC207 2024Fa.
*/
package edu.grinnell.csc207.util;

/**
 * This class contains all necessary methods to encrypt/decrypt with
 * Caeser Cipher or Vigenere Cipher algos.
*/
public class CipherUtils {
  /**
   * @param letter letter to return as int.
   * @return gives us the int value of letter.
  */
  public static int letter2int(char letter) {
    int asciival = (int) letter;
    return asciival;
  } // End of letter2int method.
  /**
   * @param asciival int to return as letter.
   * @return gives us the char corresponding to ascii (asciival).
  */
  public static char int2letter(int asciival) {
    char modletter = (char) asciival;
    return modletter;
  } // End of int2letter method.
  /**
   * @param plainText string that contains text to be encrypted.
   * @param key decides the offset for the cypher.
   * @return gives us the Caeser encrypted string.
  */
  public static String caesarEncrypt(String plainText, char key) {
    String encryptText = "";
    int alphabetsize = 'z' - 'a' + 1;
    for (int i = 0; i < plainText.length(); i++) {
      char currentChar = plainText.charAt(i);
      if (currentChar >= 'a' && currentChar <= 'z') {
        int base = 'a';
        int shift = (key - base) % alphabetsize;
        int asciiValue = (currentChar - base + shift) % alphabetsize + base;
        encryptText += (char) asciiValue;
      } else {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return "";
      } // Ensures only lowercase letters are used for input string.
    } // Loops till entire string is encrypted.
    return encryptText;
  } // End of caeserEncrypt method.
  /**
   * @param cipherText string that contains the text to be decrypted.
   * @param key decides the offset for the cipher.
   * @return gives us the Caeser decrypted string.
  */
  public static String caesarDecrypt(String cipherText, char key) {
    int alphabetsize = 'z' - 'a' + 1;
    String decryptText = "";
    for (int i = 0; i < cipherText.length(); i++) {
      char currentChar = cipherText.charAt(i);
      if (currentChar >= 'a' && currentChar <= 'z') {
        int base = 'a';
        int shift = (key - base) % alphabetsize;
        int asciiValue = (currentChar - base - shift + alphabetsize) % alphabetsize + base;
        decryptText += (char) asciiValue;
      } else {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return "";
      } // Ensures input string is made of only lowercase letters.
    } // Loops until entire string is decryped.
    return decryptText;
  } // End of caeserDecrypt method.
  /**
   * @param plainText string that contains the text to be encrypted.
   * @param keyword string that contains the key to encrypt with.
   * @return gives us the Vigenere encryped string.
  */
  public static String vigenereEncrypt(String plainText, String keyword) {
    String encryptText = "";
    int alphabetsize = 'z' - 'a' + 1;
    for (int i = 0; i < plainText.length(); i++) {
      char letter = plainText.charAt(i);
      char keyletter = keyword.charAt(i % keyword.length());
      int key = letter2int(keyletter) - 'a';
      int asciiValue = letter2int(letter) + key;
      if (asciiValue > 'z') {
        asciiValue -= alphabetsize;
      } else if (asciiValue < 'a') {
        asciiValue += alphabetsize;
      } // Makes sure letter is encryped to a lowercase letter.
      encryptText += (char) asciiValue;
    } // Loops until entire string is encryped.
    return encryptText;
  } // End of vigenereEncrypt method.
  /**
   * @param cipherText string that contains the text to be decryped.
   * @param keyword string that gives us the key to decrypt with.
   * @return gives us the Vigenere decrypted string.
  */
  public static String vigenereDecrypt(String cipherText, String keyword) {
    String decryptText = "";
    int alphabetsize = 'z' - 'a' + 1;
    for (int i = 0; i < cipherText.length(); i++) {
      char letter = cipherText.charAt(i);
      char keyletter = keyword.charAt(i % keyword.length());
      int key = letter2int(keyletter) - 'a';
      int asciiValue = letter2int(letter) - key;
      if (asciiValue < 'a') {
        asciiValue += alphabetsize;
      } // Makes sure decrypted letter is lowercase.
      decryptText += (char) asciiValue;
    } // Loops until entire string is decryped.
    return decryptText;
  } // End of vigenereDecrypt method.
  /**
   * @param cmd contains the instruction to encode or decode.
   * @param userinput contains the key for Caeser Cipher.
  */
  public static void command(String cmd, String userinput) {
    java.io.PrintWriter pen;
    pen = new java.io.PrintWriter(System.out, true);
    if (!cmd.equals("encode") && !cmd.equals("decode")) {
      System.err.println("Error: Invalid option: " + "\"" + cmd
          + "\". " + "Valid options are \"encode\" or \"decode\".");
    } // Ensures only encode or decode is entered.
    if (userinput.isEmpty()) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, "");
      } // Prints empty string for each shift.
      return;
    } // Special case for empty string input.
    if (cmd.equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        String outputString = CipherUtils.caesarEncrypt(userinput, CipherUtils.int2letter(ch));
        if (outputString != "") {
          pen.printf("n = %c: %s\n", ch, outputString);
        } else {
          break;
        } // Terminates program if non-lowercase letter string is entered.
      } // Loops for all 26 versions of encryped strings.
    } // Only runs if string is to be encoded.
    if (cmd.equals("decode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        String outputString = CipherUtils.caesarDecrypt(userinput, CipherUtils.int2letter(ch));
        if (outputString != "") {
          pen.printf("n = %c: %s\n", ch, outputString);
        } else {
          break;
        } // Terminates program if non-lowercase letter string is entered.
      } // Loops for all 26 versions of encryped strings.
    } // Only runs if string is to be decoded.
  } // End of command handling method.
} // End of CipherUtils class.
