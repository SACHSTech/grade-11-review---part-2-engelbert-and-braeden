package gr11review.part2;

import java.io.*;
import java.util.*;

public class Utility {

  /**
  *Add up all the numbers in a string to get a sum. A number is described as a series of 1 or more digit characters in a row
  * 
  * @param str the string variable being checked for numbers
  * @return the sum of the numbers in str
  * @author Braeden Hugh
  */

  public static int sumNumbers(String str)throws IOException{
    
    //initialize variables
    int intStringLength = 0;
    int intCount;
    char charCharacter;
    int intTotal = 0;
    String strString = "";

    intStringLength = str.length();

    //loop checks every character to see if it is a digit or not then adds onto 
    for(intCount=0; intCount<intStringLength; intCount++){
      charCharacter = str.charAt(intCount);

      if(Character.isDigit(charCharacter)){
        strString = strString+charCharacter;

      }else if(!strString.equals("")){
        intTotal = intTotal + Integer.parseInt(strString);
        strString = "";
      }
    }
    if(!strString.equals("")){
      intTotal = intTotal+ Integer.parseInt(strString);
    }
    return intTotal;
  }

  /**
  *Searches through a file filled with 1 word per line and returns the word that is alphabetically first
  * 
  * @param the name of the file being checked
  * @return the word in the file that is alphabetically first
  * @author Braeden Hugh
  */
  public static String alphaWord(String filenametxt)throws IOException{
    
    //initialize variables
    String strLine = "";
    String strFirst = "";
    String strFinal = "";
    int intCompare = 0;

    BufferedReader File = new BufferedReader(new FileReader(filenametxt));

    strLine = File.readLine();
    strFinal = File.readLine();

    //if there is nothing in the file close it 
    if(strLine == null){
      File.close();
      return "";
    }
    //compare each word line by line until the end of the file
    if(strLine != null){
      while(strLine != null){
        intCompare = strFinal.compareToIgnoreCase(strLine);
        if(intCompare > 0){
          strFinal = strLine;
        }
      strLine = File.readLine();

      }

    }
    File.close();
    return strFinal;
  }
  /**
  *A program that when given an array will rewrite the array in a way that will replace any value that is alone with the number to the left or right that is bigger
  * 
  * @param nums the array that is being checked for alone digits
  * @param value the value that is alone
  * @return the changed array in which all alone digits were replaced by the number to its left or right that is larger
  * @author Braeden Hugh
  */
  public static int[] notAlone(int[] nums, int value)throws IOException{
    
    //initialize varibales
    int intCount = 1;
    int intLength = 0;
    int intLeftnums = 0;
    int intRightnums = 0;

    intLength = nums.length;
    //loop that runs until the end of array and checks to see if a value is 'alone'
    while(intCount < intLength){
      
      //number to left and right of a value
      intLeftnums = nums[intCount - 1];
      intRightnums = nums[intCount + 1];

      //if a value is alone determine which value to the left or right is larger and replace the alone value with it
      if(nums[intCount] == value){
        if(intLeftnums != nums[intCount] && intRightnums != nums[intCount]){
          nums[intCount] = Math.max(intLeftnums, intRightnums);
        }
      }
      intCount = intCount +1;
    }
  return nums;
  }

  /**
  *Checks an array of numbers to see if there is a place that it can be split so that both sides are even, and returns true or false
  * 
  * @param nums the array being checked
  * @return the word in the file that is alphabetically first
  * @author Braeden Hugh
  */
  public static boolean canBalance(int[] nums)throws IOException{

    //initialize values
    int intCount = 0;
    int intLength = 0;
    int intSum = 0;
    int intHalf = 0;
    int intCounter = 0;

    intLength = nums.length;

    //get the sum of all numbers to determine a halfway
    while(intCount < intLength){
      intSum = intSum + nums[intCount];
      intCount = intCount + 1;
    }

    //halfway
    intHalf = intSum/2;

    intCount = 0;

    //checks through each value in the array and adds them up 1 at a time. If the counter passes the halfway then there is no way that it can be split in half
    while(intCount < intLength){
      intCounter = intCounter + nums[intCount];
      
      if(intCounter == intHalf){
        return true;
      }
      
      if(intCounter > intHalf){
        return false;
      }
    }
    return false;
  }
  public static void diagonal(int n)throws IOException{
    PrintWriter Writer = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt"));

    //initialize values
    int intCount = 0;
    int intCount1 = 0;
    int[][] intDiagonal;

    intDiagonal = new int[n][n];

    //loop goes through every row of the array intDiagonal
    for(intCount = 0; intCount < n; intCount++){
      //loop that goes through every collumn of the array intDiagonal
      for(intCount1 = 0; intCount1 <n; intCount1++){
        if(intCount1 < (n - intCount - 1)){
          intDiagonal[intCount][intCount1] = 0;
        }else if(intCount1 == (n - intCount - 1)){
          intDiagonal[intCount][intCount1] = 1;
        }else if(intCount1 > (n - intCount - 1)){
          intDiagonal[intCount][intCount1] = 2;
        }
      }
    }
    
    //print out the array to diaonalOut text file
    for(intCount = 0; intCount < n; intCount++){
      for(intCount1 = 0; intCount1 <n; intCount1++){
        Writer.print(intDiagonal[intCount][intCount1]);
        if(intCount1 != n - 1){
          Writer.print(", ");
        }
      }
      Writer.println();
    }
    Writer.close();
  } 
}