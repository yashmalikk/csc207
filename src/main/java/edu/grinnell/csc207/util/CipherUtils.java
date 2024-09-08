package edu.grinnell.csc207.util;

public class CipherUtils {
  public static int letter2int(char letter) {
    int asciival = (int)letter;
    return asciival; 
  }

  public static char int2letter(int asciival) {
    char modletter = (char)asciival;
    return modletter; 
  }

  public static String caesarEncrypt(String plainText, char key) {
    String encryptText = "";
    
    for (int i = 0; i < plainText.length(); i++) {
      char currentChar = plainText.charAt(i);

      if (currentChar >= 'a' && currentChar <= 'z') {
        int base = 'a';

        int shift = (key - base) % 26;

        int asciiValue = (currentChar - base + shift) % 26 + base;

        encryptText += (char) asciiValue;
      }
      
      else {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return "";
      }
    }
    return encryptText;
  }


  public static String caesarDecrypt(String cipherText, char key) {
    String decryptText = "";

    for (int i = 0; i < cipherText.length(); i++) {
      char currentChar = cipherText.charAt(i);

      if (currentChar >= 'a' && currentChar <= 'z') {
        int base = 'a';

        int shift = (key - base) % 26;
        
        int asciiValue = (currentChar - base - shift + 26) % 26 + base;

        decryptText += (char) asciiValue;
      } 

      else {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return "";
      }
    }
    return decryptText;
  }


  public static String vigenereEncrypt(String plainText, String keyword) {
    String encryptText = "";

    for (int i = 0; i < plainText.length(); i++) {
      char letter = plainText.charAt(i);
      
      char keyletter = keyword.charAt(i % keyword.length());

      int key = letter2int(keyletter) - 'a'; 
      
      int asciiValue = letter2int(letter) + key;

      if (asciiValue > 'z') {
        asciiValue -= 26;
      } 
      
      else if (asciiValue < 'a') {
        asciiValue += 26;
      }
      
      encryptText += (char) asciiValue;
    }
    return encryptText;
  }


  public static String vigenereDecrypt(String cipherText, String keyword) {
    String decryptText = "";

    for (int i = 0; i < cipherText.length(); i++) {
      char letter = cipherText.charAt(i);

      char keyletter = keyword.charAt(i % keyword.length());

      int key = letter2int(keyletter) - 'a';

      int asciiValue = letter2int(letter) - key;

      if (asciiValue < 'a') {
        asciiValue += 26;
      }

      decryptText += (char) asciiValue;
    }
    return decryptText;
  }


  public static void command(String cmd, String userinput){
    java.io.PrintWriter pen;
    pen = new java.io.PrintWriter(System.out, true);
    
    if (!cmd.equals("encode") && !cmd.equals("decode")) {
      System.err.println("Error: Invalid option: "+ "\"" + cmd + "\". " + "Valid options are \"encode\" or \"decode\".");
    }

    if (cmd.equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        String outputString = CipherUtils.caesarEncrypt(userinput, CipherUtils.int2letter(ch));

        if (outputString != "") {
          pen.printf("n = %d: %s\n", (CipherUtils.letter2int(ch) - 97), outputString);
        }
        else{
          break;
        }
      }
    }

    if (cmd.equals("decode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        String outputString = CipherUtils.caesarDecrypt(userinput, CipherUtils.int2letter(ch));

        if (outputString != "") {
          pen.printf("n = %d: %s\n", (CipherUtils.letter2int(ch) - 97), outputString);
        }
        else{
          break;
        }
      }
    }
  }
}