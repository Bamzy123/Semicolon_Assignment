import java.util.Scanner;
public class Number{
	public static void main(String[] args){
 	
	Scanner input = new Scanner(System.in);

	int negative = 0;
	int positive = 0;
	int zero = 0;

	System.out.print("Enter number: ");
	int number1 = input.nextInt();
	if (number1 > 0) {
	positive = positive + 1;
	}
	else if (number1 < 0) {
	negative = negative + 1;
	}
	else {
	zero = zero + 1;
	}
	System.out.print("Enter number: ");
	int number2 = input.nextInt();
	if (number2 > 0) {
	positive = positive + 1;
	}
	else if (number2 < 0) {
	negative = negative + 1;
	}
	else {
	zero = zero + 1;
	}
	  System.out.print("Enter number: ");
	int number3 = input.nextInt();
	if (number3 > 0) {
	positive = positive + 1;
	}
	else if (number3 < 0) {
	negative = negative + 1;
	}
	else {
	zero = zero + 1;
	}
	   System.out.print("Enter number: ");
	int number4 = input.nextInt();
	if (number4 > 0) {
	positive = positive + 1;
	 
	}
	
	else if (number4 < 0) {
	negative = negative + 1;
	}

	else {
	zero = zero + 1;
	}
	  System.out.print("Enter number: ");
	int number5 = input.nextInt();

	if (number5 > 0) {
	positive = positive + 1;
	 
	}
	
	else if (number5 < 0) {
	negative = negative + 1;
	}

	else {
	zero = zero + 1;
	}
  		System.out.println(negative);
		System.out.println(positive);
		System.out.println(zero);
  }
}