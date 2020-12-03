package gr11review.part2;

import java.io.*;
import java.util.*;

public class Utility {

  //Methods 2
  //add up all the numbers in a string to get a sumNumbers
  //get length of string so to run for loop for correct ammount of time
  
  public static int sumNumbers(String str){
    
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
        intTotal = intTotal+ Integer.parseInt(strString);
        strString = "";
      }
    }
    if(!strString.equals("")){
      intTotal = intTotal+ Integer.parseInt(strString);
    }
    return intTotal;
  }

  public static String alphaWord(String filenametxt){


  }
}