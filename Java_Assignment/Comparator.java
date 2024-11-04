import java.util.Scanner;

public class Comparator{

	public static void main(String... agrs){

	Scanner joy = new Scanner(System.in);

	int x = 0;

		do{
			System.out.println("Please enter first number: ");
			int firstvalue = joy.nextInt();

			System.out.println("Please enter second number: ");
			int secondValue = joy.nextInt();

			if (firstvalue == secondValue)
				System.out.println("The number is equal to (0)");

			else if (firstvalue > secondValue)
				System.out.println("The first is equal to (1)");

			else
				System.out.println("The second is equal to (-1)");

			x++;
		}
		while (x < 3);
	}

}