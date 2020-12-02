package gr11review.part2;

import java.io.*;
import java.util.*;

/**
*Java file that contains all methods
* @author: E. Aroozoo
*/

public class Utility {

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

      intCounter = 1;
      strZP = "";

      //If Sentence less than 2 words, send back sentence
      if(strZipZap.length() <= 2) {
        return strZipZap;
      }
      //Counter for sentence, checks if there is z and p
      for(intCounter = 0; intCounter < strZipZap.length() - 2; intCounter++) {
        if(strZipZap.charAt(intCounter) == 'z' && strZipZap.charAt(intCounter + 2) == 'p') {
          strZP += "zp";
          intCounter = intCounter + 2;
        } else {
          strZP = strZP + strZipZap.charAt(intCounter);
        }
      }
      //Returning Sentence
      return strZP;
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

      //Setting up
      strWord = filename.readLine();
      strLongestWord = filename.readLine();


      //Comparing the next word to see if it is longer
      while(strWord != null) {
        intWordLength = strWord.length();
        intLongestWordLength = strLongestWord.length();
          if(intWordLength >= intLongestWordLength) {
            strLongestWord = strWord;
        }
        strWord = filename.readLine();
      }
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

    intMultiple = 1;

      for(i = 0; i < nums.length; i++) {
        if(nums[i] % 10 == 0) {
          intMultiple = nums[i];
        } else if(nums[i] % 10 != 0 && intMultiple != 1) {
          nums[i] = intMultiple;
        }
      }
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
          InputPascal.println(intPascal[intCounterA][intCounterB] + ", ");
          if(intCounterB != j -1) {
            InputPascal.println(" "); 
          }
        }
      }
    //Closing text file
    InputPascal.close();
    }
//end of utility file
}