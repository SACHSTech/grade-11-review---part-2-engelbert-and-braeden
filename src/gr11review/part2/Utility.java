package gr11review.part2;

import java.io.*;
import java.util.*;

public class Utility {

  //Methods 2
  //add up all the numbers in a string to get a sumNumbers
  //get length of string so to run for loop for correct ammount of time

  public static int sumNumbers(String str)throws IOException{
    
    int intStringLength = 0;
    int intCount;
    char charCharacter;
    int intTotal = 0;
    String strString = "";

    intStringLength = str.length();

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

  public static String alphaWord(String filenametxt)throws IOException{
    
    //access a file and determine which word is alphabetically first

    String strLine = "";
    String strFirst = "";
    String strFinal = "";
    int intCompare = 0;

    BufferedReader File = new BufferedReader(new FileReader(filenametxt));

    strLine = File.readLine();
    strFinal = File.readLine();

    if(strLine == null){
      File.close();
      return "";
    }
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

  public static int[] notAlone(int[] nums, int value)throws IOException{
    
    int intCount = 1;
    int intLength = 0;
    int intLeftnums = 0;
    int intRightnums = 0;

    intLength = nums.length;

     for (intCount = 1; intCount < intLength-1; intCount++) {
      
      intLeftnums = nums[intCount - 1];
      intRightnums = nums[intCount + 1];

      if(nums[intCount] == value){
        if(intLeftnums != nums[intCount] && intRightnums != nums[intCount]){
          nums[intCount] = Math.max(intLeftnums, intRightnums);
        }
      }
    }
  return nums;
  }

  
}