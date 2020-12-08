package gr11review.part2;

import java.io.*;
import java.util.Arrays;

public class Main{
  public static void main(String[] args) throws IOException{

    int[] intNums = {1, 2, 3, 2, 5, 2};

    intNums = Utility.notAlone(intNums, 2);

    System.out.println(Arrays.toString(intNums));
    
  }
}