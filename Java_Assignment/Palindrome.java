import java.util.Scanner;

public class Palindrome{

	public static void main(String... args){

	Scanner input = new Scanner(System.in);

	int i = 1;

		while (i <= 1){
			System.out.print("Enter numbers: ");
			int value = input.nextInt();

			int digit = value / 10000;
			int result1 = value % 10000;
			int result2 = result1 / 1000;
			int result3 = result2 % 1000;
			int result4 = result3 / 100;
			int result5 = result4 % 100;
			int result6 = result5 / 10;
			int result7 = result6 % 10;

		System.out.println(value);
			i++;
		}
	}
}