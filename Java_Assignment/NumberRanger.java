import java.util.Scanner;

import java.util.Scanner;
public class NumberRanger {
 public static void main(String... args){

 	Scanner input = new Scanner(System.in);

			int largest = 0;
			int smallest = 1;
			int counter = 0;

		while( counter != -1) {
		      System.out.print("Enter a number:  ");
		        counter = input.nextInt();

			
		        
	
			if (counter > largest){
				largest = counter;
			}
		        if (counter < smallest){
				smallest = counter;
			   }
	}
		System.out.println("the largest number is " + largest);
		System.out.println("the smallest number is " + smallest);
   }
}