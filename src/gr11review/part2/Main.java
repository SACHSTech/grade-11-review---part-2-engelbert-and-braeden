package gr11review.part2;

/**
*Java file that tests methods
* @author: E. Aroozoo
*/

import gr11review.part2.Utility.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
  
  //Testing Methods 1
	String strZipZap;
	System.out.println(Utility.zipZap("zipxxxxzopzap"));

  //Testing FileIO - Read 1
  String strLongestWord;
  strLongestWord = Utility.longestWord("src/gr11review/part2/words.txt");
  System.out.println(strLongestWord);

	}
}
