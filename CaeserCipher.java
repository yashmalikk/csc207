class Encoder{
  public static void encodingAlgo(String Pt, int key){
    for (int i = 0; i < Pt.length(); i++) {
     char letter = Pt.charAt(i);
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
  public static void decodingAlgo(String Pt, int key){
    for (int i = 0; i < Pt.length(); i++) {
     char letter = Pt.charAt(i);
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
  public static void argno(String args[]){
    if (args.length != 2){
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    }
  }

  public static void command(String cmd, String plaintext){
    if (!cmd.equals("encode") && !cmd.equals("decode")) {
      System.err.println("Valid options are \"encode\" or \"decode\"");
        System.exit(1);
    }

    if (cmd.equals("encode")) {
      for (int i = 0; i < 26; i++) {
        System.out.print("n = " + i +": ");
        Encoder.encodingAlgo(plaintext,i);
      } 
    }

    if (cmd.equals("decode")) {
      for (int i = 0; i < 26; i++) {
        System.out.print("n = " + i +": ");
        Decoder.decodingAlgo(plaintext,i);
      } 
    }
  }
}

public class CaeserCipher {
  public static void main(String args[]){
    InputHandling.argno(args);
    InputHandling.command(args[0],args[1]);
    System.out.println();
  }
}
