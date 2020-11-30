package gr11review.part2;

import java.io.*;

/**
*Java file that contains all methods
* @author: E. Aroozoo
*/

public class Utility {

    /**
    *Create a method that for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and *ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap"  *yields *"zpXzp".
    *
    *@param strZipZap the string that contains the patterns with the z's and p's
    *@return strZP the string without the letter between z and p
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
    *@param strZipZap the string that contains the patterns with the z's and p's
    *@return strZP the string without the letter between z and p
    * @author: E. Aroozoo
    */

    public static String longestWord(String filenametxt) throws IOException {
      BufferedReader filename = new BufferedReader(new FileReader(filenametxt));

      //Variables
      String strWord;
      String strLongestWord;

      strWord = filename.readLine();
      strLongestWord = filename.readLine();

      //Comparing the next word to see if it is longer
      while(strWord != "") {
        if(strWord.length() >= strLongestWord.length()) {
          strWord = strLongestWord;
        }
        strLongestWord = filename.readLine();
      }
      filename.close();
      //Returning Longest Word
      return strWord;
    }
  
//end of utility file
}