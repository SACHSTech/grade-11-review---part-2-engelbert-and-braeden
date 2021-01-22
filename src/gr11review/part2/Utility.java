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


    /**
    *Create a method that for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and *ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap"  *yields *"zpXzp".
    *
    * @param strZipZap - the string that contains the patterns with the z's and p's
    * @return strZP - the string without the letter between z and p
    * @author: E. Aroozoo
    */

    public static String zipZap(String strZipZap) {

      //Variables
      String strZP;
      int intCounter;
      int intSentenceLength;

      //Setting Variables
      strZP = "";
      intSentenceLength = strZipZap.length();

      //If Sentence less than 2 letters, send back sentence (does not contain z*p pattern)
      if(intSentenceLength >= 3) {
         //Counter for sentence, checks if there is z and p
        for(intCounter = 0;intCounter < intSentenceLength; intCounter++) {
          strZP += strZipZap.substring(intCounter, intCounter + 1);
            if(intCounter > 0 && intCounter < intSentenceLength - 1) {

              //Finds out if there is a z and p pattern and collects the string
              if(strZipZap.charAt(intCounter - 1) == 'z' && strZipZap.charAt(intCounter+1) == 'p')
              strZP = strZP.substring(0,strZP.length() - 1);
            }
        }

        //Return string removing the letter between "z" and "p"
        return strZP;
      } else {
        return strZP;
      }
    }
    /**
    *Write a method longestWord(String filenametxt) such that given the name of a file filenametxt that *contains a single word on each line, returns the longest word in the file.
    *
    * @param filename - the file that contains all the words
    * @return strWord - the string that is the longest in the file
    * @author: E. Aroozoo
    */

    public static String longestWord(String filenametxt) throws IOException {
      BufferedReader filename = new BufferedReader(new FileReader(filenametxt));

      //Variables
      String strWord;
      String strLongestWord;
      int intWordLength;
      int intLongestWordLength;

      //Setting Variables (Putting the data from the file into the variable)
      strWord = filename.readLine();
      strLongestWord = filename.readLine();


      //Comparing the next word to see if it is longer than the current word
      while(strWord != null) {
        intWordLength = strWord.length();
        intLongestWordLength = strLongestWord.length();
          if(intWordLength >= intLongestWordLength) {
            strLongestWord = strWord;
        }
        strWord = filename.readLine();
      }

      //Closing File
      filename.close();
      //Returning Longest Word
      return strLongestWord;
    }
    /**
    *For each multiple of 10 in the given array, change all the values following it to be that multiple of *10, until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
    *
    * @param nums - the array containing the set of numbers
    * @return nums - the updated array containing the same multiples of 10
    * @author: E. Aroozoo
    */
    public static int[] tenRun(int[] nums) {

    //Variables
    int i;
    int intMultiple;

    //Setting Variable
    intMultiple = 1;

      for(i = 0; i < nums.length; i++) {

        //We know it is a multiple of 10 if the remainder is 0 when divided by 10
        if(nums[i] % 10 == 0) {
          intMultiple = nums[i];

        //If it is not a multiple of 10, replace it with the multiple of 10
        } else if(nums[i] % 10 != 0 && intMultiple != 1) {
          nums[i] = intMultiple;
        }
      }

    //Returning array with the new values
    return nums;
    }
    /**
    *Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order
    *
    * @param inner - the inner array
    * @param outer - the outer array 
    * @return true/false if numbers in inner array are in outer array
    * @author: E. Aroozoo
    */
    public static boolean linearIn(int[] outer, int[] inner) {
    
    //Variables
    int intNumber;
    int i;
    int t;

    //Setting Variables
    intNumber = 0;
    i = 0;
    t = 0;
    
    //Return true since technically "all" numbers appear in outter array
    if(inner.length == 0) {
      return true;
    } 

      //Going through the array
      while(i < outer.length) {
        i++;

        //Comparing inner to outer values to see if the numbers matches
        if(outer[i] == inner[t]) {
          intNumber++;
          t++;

        //If outer has more unique numbers than inner, return false
        } else if(outer[i] > inner[t]) {
          return false;

        //If they have same amount of unique numbers, return true
        } if(intNumber == inner.length) {
        return true;
        }
      }
      return false;
    }
    /**
    *Write a method pascalTri(int i, int j) that outputs to a text file pascalOut.txt, a comma separted table containing i rows and j columns of pascal's triangle. Be sure to use two-dimensional array in your solution.
    *
    * @param i - rows of the pascals triangle
    * @param j - columns of the pascals triangle 
    * @author: E. Aroozoo
    */
    public static void pascalTri(int f, int j) throws IOException{
      PrintWriter InputPascal = new PrintWriter(new FileWriter("src/gr11review/part2/pascalOut.txt"));

      //Variables
      int intCounterA;
      int intCounterB;
      int intPascal[][] = new int[f][j];

      //Setting Variables
      intCounterA = 0;
      intCounterB = 0;

      //Setting up first row equal to one
      while(intCounterA < f) {
        intPascal[intCounterA][0] = 1;
        intCounterA++;
      } 

      //Setting up first column equal to one
      while(intCounterB < j) {
        intPascal[0][intCounterB] = 1;
        intCounterB++;
      }

      //Using the values from the column and row before to generate the corner values
      for(intCounterA = 1; intCounterA < f; intCounterA++) {
        for(intCounterB = 1; intCounterB < j; intCounterB++) {
          intPascal[intCounterA][intCounterB] = intPascal[intCounterA - 1][intCounterB] +intPascal[intCounterA][intCounterB - 1];
        }
      }

      //Printing the values into pascalOut.txt
      for(intCounterA = 0; intCounterA < f; intCounterA++) {
        for(intCounterB = 0; intCounterB < j; intCounterB++) {
          InputPascal.print(intPascal[intCounterA][intCounterB] + ", ");
          if(intCounterB == j -1) {
            InputPascal.println(" "); 
          }
        }
      }
    //Closing text file
    InputPascal.close();
    }
//end of utility file

}