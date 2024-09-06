package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    int asciival = (int)letter;
    return asciival; // STUB
  }

  private static char int2letter(int asciival) {
    char modletter = (char)asciival;
    return modletter; // STUB
  }

  public static String caesarEncrypt(String plainText, char key) {
    String encryptText = new String();
    for (int i = 0; i < plainText.length(); i++) {

      int asciival = letter2int(plainText.charAt(i)) + letter2int(key);

      if (asciival > 122) {
        asciival = asciival - 26;
      }

      else if (asciival < 97) {
      
        asciival = asciival + 26;
      }

      char modletter = int2letter(asciival);
      encryptText += modletter; 
    }
    return encryptText;
  }

  public static String caesarDecrypt(String cipherText, char key) {
    String decryptText = new String();
    for (int i = 0; i < cipherText.length(); i++) {

      int asciival = letter2int(cipherText.charAt(i)) - letter2int(key);

      if (asciival > 122) {
        asciival = asciival - 26;
      }

      else if (asciival < 97) {
        asciival = asciival + 26;
      }

      char modletter = int2letter(asciival);
      decryptText += modletter; 
    }
    return decryptText; // STUB
  }
  

  public static String vigenereEncrypt(String plainText, String keyword) {
    String encryptText = new String();

    for (int i = 0; i < plainText.length(); i++) {
      char letter = plainText.charAt(i);
      char keyletter = plainText.charAt(i % keyword.length());

      int key = letter2int(keyletter) - 'a'; 
      int asciival = letter2int(letter) + key;
      
      if (asciival > 'z') {
        asciival -= 26;
      }

      else if (asciival < 'a') {
        asciival += 26;
      }
      
      char modletter = int2letter(asciival);
      encryptText += modletter;
    }
    return encryptText; // STUB
  }

public static String vigenereDecrypt(String cipherText, String keyword) {
  String decryptText = new String();

    for (int i = 0; i < cipherText.length(); i++) {
      char letter = cipherText.charAt(i);
      char keyletter = keyword.charAt(i % keyword.length());

      int key = letter2int(keyletter) - 'a';
      int asciival = letter2int(letter) - key;

      if (asciival > 'z') {
        asciival -= 26;
      }

      else if (asciival < 'a') {
        asciival += 26;
      }
      
      char modletter = (char) asciival;
      decryptText += modletter;
    }
    return decryptText;
  }
}