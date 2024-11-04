import java.util.Scanner;

public class NumberValidation{

	public static void main(String... args){

	Scanner joy = new Scanner(System.in);

	int userInput = 0;

		while (true){
			System.out.print("Please enter 1 or 2: ");
			int number = joy.nextInt();

			if (number == 1 || number == 2){
				System.out.println("you entered: " + number);
					break;
			}
			else{
				System.out.println("invalid number. Please enter 1 or 2");
			}
		}
	}
}