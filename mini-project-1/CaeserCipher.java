/**
 * @author Yash Malik
 * For CSC-207 Fall 2024 with Professor Rebelsky
 * Mini-Project Number 1
*/

class Encoder{
  /**
   * This class contains the Encoding algorithm and is only called when user writes "encode" in input
   * @param plaintext  - String with the plaintext
   * @param key - int with the key used to encode the plaintext
   */
  public static void encodingAlgo(String plaintext, int key){
    for (int i = 0; i < plaintext.length(); i++) {
      char letter = plaintext.charAt(i);
      int asciival = (int)letter + key;

      if (asciival > 122) {
        asciival = asciival - 26;
      }

      else if (asciival < 97) {
        asciival = asciival + 26;
      }

      char modletter = (char) asciival;
      System.out.print(modletter); 
    }
    System.out.println();
  }
}

class Decoder{
  /**
   * This class contains the Decoding algorithm and is only called when user writes "decode" in input
   * @param ciphertext  - String with the ciphertext
   * @param key - int with the key used to decode the ciphertext
   */
  public static void decodingAlgo(String ciphertext, int key){
    for (int i = 0; i < ciphertext.length(); i++) {
      char letter = ciphertext.charAt(i);
      int asciival = (int)letter - key;

      if (asciival > 122) {
        asciival = asciival - 26;
      }

      else if (asciival < 97) {
        asciival = asciival + 26;
      }

      char modletter = (char) asciival;
      System.out.print(modletter); 
    }
    System.out.println();
  }
}

class InputHandling{
  /**
   * Validated the number of arguments passed in the program.
   * @param args - array of strings of arguments
   */
  public static void argno(String args[]){
    if (args.length != 2){
      System.err.println("Incorrect number of parameters");
      System.out.println();
      System.exit(2);
    }
  }

  /**
   * Executes appropriate command based on first argument (i.e. encode or decode)
   * @param cmd - first argument
   * @param plaintext - second argument
   */
  public static void command(String cmd, String userinput){
    if (!cmd.equals("encode") && !cmd.equals("decode")) {
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.out.println();
      System.exit(1);
    }

    if (cmd.equals("encode")) {
      for (int i = 0; i < 26; i++) {
        System.out.print("n = " + i +": ");
        Encoder.encodingAlgo(userinput,i);
      } 
    }

    if (cmd.equals("decode")) {
      for (int i = 0; i < 26; i++) {
        System.out.print("n = " + i +": ");
        Decoder.decodingAlgo(userinput,i);
      } 
    }
  }
}

public class CaeserCipher {
  /**
   * Main method that handles program execution
   * @param args - array of passed arguments
   */
  public static void main(String args[]){
    InputHandling.argno(args);
    InputHandling.command(args[0],args[1]);
    System.out.println();
  }
}
