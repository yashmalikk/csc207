/**
 * @author: Yash Malik.
 * This program is meant to be run with 2 argumentss:
 * encode or decode must one of the arguments.
 * Made for CSC207 2024Fa.
 */
package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * This class contains code that allows the program to utilize all methods in CipherUtils.
 * The CipherUtils.command method reads input and performs tasks as needed.
 */

public class AllCaesar {
  /**
   * @param args - an array of the arguments that this function is called with.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      // Program execution doesn't happen if incorrect number of parameters are given.
      System.err.println("Error: Incorrect number of parameters.");
    } else {
      CipherUtils.command(args[0], args[1]);
    } // Program execution occurs after checking for valid number of parameters.
    pen.printf("\n");
    pen.close();
  } // End of main function.
} // End of AllCaesar Class.
