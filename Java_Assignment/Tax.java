import java.util.Scanner;
public class Tax{
 public static void main(String... args){

	Scanner input = new Scanner(System.in);

	for(int i = 0; i < 3; i++){
 		System.out.println("Enter your name: ");
		String name = input.nextLine();

		System.out.println("Input amount: ");
		int taxAmount = input.nextInt();
		
		input.nextLine();

		double taxToPay;

		if (taxAmount < 30000) {
			taxToPay = taxAmount * 0.15;
		   } else {
			taxToPay = taxAmount * 0.20;
		    }
		System.out.printf("Name: %s%n", name);
        	System.out.printf("Income Amount: $%d%n", taxAmount);
		System.out.printf("Tax to Pay: $%.2f%n", taxToPay);
		}
	        
	}

}