package gr11review.part2;

import java.io.*;
import gr11review.part2.Utility.*;

public class Main{
  public static void main(String[] args) throws IOException{

    String strAlphabet = "";
    
    strAlphabet = Utility.alphaword(Alphaword.txt);
    System.out.println(strAlphabet);
  }
}