import java.util.Scanner;

public class PointlineChecker{

	public static void main(String... args){

	Scanner input = new Scanner(System.in);

	int check = 0;

		do{

			System.out.println("coordinates of x: ");
			int point = input.nextInt();

			System.out.println("coordinates of y: ");
			int points = input.nextInt();

			if (point == points)
				System.out.println("The points are located on a line perpendicular to an axis: " + point);

			if (point != points)
				System.out.println("The points are not located on a line perpendicular to an axis: " + points);

			check++;
		}
		while (check < 2);		
	}
}