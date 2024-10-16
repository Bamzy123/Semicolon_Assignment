import java.util.Scanner;
public class Code{
  public static void main(String[] args){
	Scanner input = new Scanner(System.in);

	System.out.print("Enter the length of square: ");
	int length = input.nextInt();

	System.out.print("Enter the breath of square: ");
	int breath = input.nextInt();

	for (int s = 0; s < length; s++){
	for (int w = 0; w < breath; w++){
	System.out.print("o");
	     }  
			System.out.println();       
             }
	}

   }