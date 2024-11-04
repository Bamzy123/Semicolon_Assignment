import java.util.Scanner;

public class ReadNumber{

	public static void main(String... args){

	Scanner input = new Scanner(System.in);

	System.out.println("Enter desired number: ");
	int desiredNumber = input.nextInt();

	int sum = 0;
	int count = 0;

		do{
			System.out.println("Input a number: ");
			int value = input.nextInt();
			
			sum += value;

			count++;

		System.out.println("The sum is: " + sum);
		System.out.println("Value entered: " + count);
		}
		while (sum < desiredNumber);
	}
}