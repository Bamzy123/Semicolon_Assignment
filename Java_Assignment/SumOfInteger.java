import java.util.Scanner;

/** 
 *calculate the sum of the digits of a three-digit integer.
*/

 public class SumOfInteger{
   public static void main(String[] args){

  	Scanner input = new Scanner(System.in); // create a scanner object for the input
	// prompting the user to enter number
	System.out.println("Enter a number between 0 and 1000: "); 
	int num1 = input.nextInt(); // read the integer input from the user
	
	// Calculate the hundreds and tens
	int resultOne = num1 / 100; // dividing the input by 100
	int reminder = num1 % 100; // calculating to get the reminder by 100
	int resultTwo = reminder / 10; // dividing the remainder by 10
        int  resultThree = reminder % 10; // calculating to get the remainder by 10

	int sum = resultOne + resultTwo + resultThree; // suming the results together

	System.out.printf("The sum of the digit is %d", sum); // print out the result using printf
}

}