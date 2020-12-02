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

  //Setting up switch
  String strOption;

  //Switch Options
  System.out.println("Engelbert and Braeden's Grade 11 Review Part 2\nSelect program to run:\n1. Methods 1\n2. FileIO - Read\n3. Array 1 - One Dimensional\n4. Array 3 - One Dimensional - Two Loops\n5. Array 5 -  Two Dimensional");
  strOption = key.readLine();
  switch(strOption) {
    case "1":
      //Methods 1
    	String strZipZap;

     //Zip Zap User Input
     System.out.print("Type your ZipZap pattern: ");
     strZipZap = key.readLine();
  	  System.out.println(Utility.zipZap(strZipZap));
      break;
    case "2":
      //FileIO - Read 1
     System.out.println("The longest word in the Words.txt is: " + Utility.longestWord("src/gr11review/part2/words.txt"));
     break;
    case "3":
     //Array 1 - One Dimensional
      int intInput;
      int i;

     //User Input for Array
     System.out.print("How many numbers do you want to enter into the array: ");
     intInput = Integer.parseInt(key.readLine());
     System.out.println("Input your numbers below: ");
     int[] nums = new int[intInput];
     for(i = 0; i < intInput; i++) {
     nums[i] = Integer.parseInt(key.readLine());
    }

      //Printing out array
      nums = Utility.tenRun(nums);
      System.out.println(Arrays.toString(nums));
      break;
    case "4":
      //Array 3 - One Dimensional - Two Loops
      
     //User Input for Outer Array
     System.out.print("How many numbers do you want to enter into the outer array: ");
     intInput = Integer.parseInt(key.readLine());
     System.out.println("Input your numbers below: ");
     int[] outer = new int[intInput];
       for(i = 0; i < intInput; i++) {
        outer[i] = Integer.parseInt(key.readLine());
        }
     //User Input for Inner Array
     System.out.print("How many numbers do you want to enter into the inner array: ");
     intInput = Integer.parseInt(key.readLine());
     System.out.println("Input your numbers below: ");
     int[] inner = new int[intInput];
       for(i = 0; i < intInput; i++) {
         inner[i] = Integer.parseInt(key.readLine());
        }
      
      //Printing out true or false
      System.out.println(Utility.linearIn(outer , inner));
      break;
    case "5":
      //Array 5 - Two Dimensional

      //User Input for Pascal Rows
      System.out.print("How many rows do you want to generate: ");
      int f =  Integer.parseInt(key.readLine());

      //User Input for Pascal Columns
      System.out.print("How many columns do you want to generate: ");
      int j = Integer.parseInt(key.readLine());

      //Printing values into pascalOut.txt
      Utility.pascalTri(f, j);
      break;
      default:
      System.out.println("Not a valid option.");
    }
  }
}
