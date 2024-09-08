package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
    }
    
    else{
      CipherUtils.command(args[0], args[1]);
    }

    pen.printf("\n");
    pen.close();
  }
}
