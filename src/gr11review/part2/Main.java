package gr11review.part2;

import java.io.*;
import gr11review.part2.Utility.*;

public class Main{
  public static void main(String[] args) throws IOException{

   BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    int intTotal1;
    String strSumNumString;

    System.out.println("Type a string");
    strSumNumString = keyboard.readLine();

    intTotal1 = Utility.sumNumbers(strSumNumString);
    System.out.println(intTotal1);

  }
}