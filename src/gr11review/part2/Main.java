package gr11review.part2;

/**
*Java file that tests methods
* @author: E. Aroozoo
*/

import gr11review.part2.Utility.*;
import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
  BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

  //Methods 1
	String strZipZap;
	System.out.println(Utility.zipZap("zipxxxxzopzap"));

  //FileIO - Read 1
  System.out.println(Utility.longestWord("src/gr11review/part2/words.txt"));

  //Array 1 - One Dimensional
  int intInput;
  int i;

  System.out.print("How many numbers do you want to enter into the array: ");
  intInput = Integer.parseInt(key.readLine());
  System.out.println("Input your numbers below: ");
  int[] nums = new int[intInput];
    for(i = 0; i < intInput; i++) {
     nums[i] = Integer.parseInt(key.readLine());
    }
    nums = Utility.tenRun(nums);
    System.out.println(Arrays.toString(nums));

  //Array 3 - One Dimensional - Two Loops
	}
}
