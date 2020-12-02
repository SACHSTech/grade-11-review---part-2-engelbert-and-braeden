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
      for(i = 0; i < inner.length; i++) {
        if(inner[i] == outer[t]) {
          intNumber++;
          t++;
        } else if(inner[i] < outer[t]) {
          return false;
        } else if(intNumber == inner.length) {
          return true;
        }
      }
      return false;
    }
//end of utility file
}