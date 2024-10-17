import java.util.Scanner;
  public class SumOfDigits{
	public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.print("Enter a number between 0 and 1000: ");
	int num = input.nextInt();

	int calculate = num / 100;
	int calculate1 = num % 100;
	int calculate2 = calculate1 / 10;
	int calculate3 = calculate2 % 10;

	int result = calculate + calculate2 + calculate3;

System.out.printf("The sum of the digit is %d", result);
	

	}

}