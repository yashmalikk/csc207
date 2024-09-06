package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String str = "helloworld";

    for (char ch = 'a'; ch <= 'z'; ch++) {
      pen.printf("n = %d: %s\n", CipherUtils.letter2int(ch) - 'a' , CipherUtils.caesarEncrypt(str, ch));
    }
    
    pen.close();
  }
}
