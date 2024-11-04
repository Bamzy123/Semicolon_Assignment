import java.util.Scanner;

public class TwoLargeNumber{

	public static void main(String... args){

	Scanner input = new Scanner(System.in); 

	int largest = 0;
	int i = 1;
	
	int number;
		do{
			System.out.println("Input a number: ");
			number = input.nextInt();
			   i++;
			if (number > largest)
				largest = number;
				
			
		}
		while (i <= 10);
		System.out.println("largest is: " + largest);
	}
}