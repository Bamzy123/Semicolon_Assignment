import java.util.Scanner;

public class  Barchart {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);


		System.out.println("enter 5 numbers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		int number4 = input.nextInt();
		int number5 = input.nextInt();

		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		int counter4 = 0;
		int counter5 = 0;

		if (number1 < 30 && number2 < 30 && number3 < 30 && number4 < 30 && number5 < 30) {
		
			while (counter1 < number1) {
				System.out.print("*");
				counter1++;
			}

			System.out.println();			

			while (counter2 < number2) {
				System.out.print("*");
				counter2++;
			}

			System.out.println();

			while (counter3 < number3) {
				System.out.print("*");
				counter3++;
			}

			System.out.println();

			while (counter4 < number4) {
				System.out.print("*");
				counter4++;
			}

			System.out.println();

			while (counter5 < number5) {
				System.out.print("*");
				counter5++;
			}

			System.out.println();

		} else {
			System.out.println("exceeded limit of 30");
		}	
	}
}