/**
 * Made by Yash Malik
 * For CSC-207 Fall 2024 with Professor Rebelsky
 * Mini-Project Number 1
 */

 class Encoder {
  public static void encodingAlgo(String Pt, String keyword) {
    for (int i = 0; i < Pt.length(); i++) {
      char letter = Pt.charAt(i);
      char keyletter = keyword.charAt(i % keyword.length());
      int key = (int) keyletter - 'a'; 
      int asciival = (int) letter + key;
      if (asciival > 'z') {
          asciival -= 26;
      }
      else if (asciival < 'a') {
          asciival += 26;
      }
      
      char modletter = (char) asciival;
      System.out.print(modletter);
    }
    System.out.println();
  }
}

class Decoder {
  public static void decodingAlgo(String Pt, String keyword) {
    for (int i = 0; i < Pt.length(); i++) {
      char letter = Pt.charAt(i);
      char keyletter = keyword.charAt(i % keyword.length());
      int key = (int) keyletter - 'a';
      int asciival = (int) letter - key;
      if (asciival > 'z') {
        asciival -= 26;
        }
      else if (asciival < 'a') {
        asciival += 26;
      }
      
      char modletter = (char) asciival;
      System.out.print(modletter);
  }
  System.out.println();
  }
}

class InputHandling {
  public static void argno(String args[]) {
    if (args.length <= 1 || args.length >3 ) {
      System.err.println("Incorrect number of parameters");
      System.out.println();
      System.exit(2);
  }
  if (args.length == 2) {
    System.out.println(args[1]);
    System.out.println();
    System.exit(0);
  }
}


  public static void command(String cmd, String plaintext, String keyword) {
    if (!cmd.equals("encode") && !cmd.equals("decode")) {
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.out.println();
      System.exit(1);
    }

    if (cmd.equals("encode")) {
      Encoder.encodingAlgo(plaintext, keyword); 
    }

    if (cmd.equals("decode")) {
      Decoder.decodingAlgo(plaintext, keyword);
    }
  }
}

public class VigenereCipher {
  public static void main(String args[]) {
      InputHandling.argno(args);
      InputHandling.command(args[0], args[1], args[2]);
      System.out.println();
  }
}
