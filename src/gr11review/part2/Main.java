package gr11review.part2;

import java.io.*;
import java.util.Arrays;

public class Main{
  public static void main(String[] args) throws IOException{

    String strAlphabet = "";
    
    strAlphabet = Utility.alphaWord("src/gr11review/part2/Alphaword.txt");
    System.out.println(strAlphabet);
  }
}