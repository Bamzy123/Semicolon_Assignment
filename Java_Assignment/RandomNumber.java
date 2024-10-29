import java.util.Random;
import java.util.Scanner;

public class RandomNumber{
 public static void main(String[] args){

        Random random = new Random();

	Scanner input = new Scanner(System.in);

	int randomNumber = random.nextInt(1,10);
	System.out.print("randomNumber");
	int userGuess = 0;

	while(userGuess != randomNumber){
	  System.out.print("Input guess number: ");
	   userGuess = input.nextInt();

	  if (userGuess < randomNumber){
	     System.out.println("Too low, try again.");
	      }
	  else if (userGuess > randomNumber){
	     System.out.println("Too high, try again.");
	         }
	  else{
	     System.out.println("Correct guess.");
	   }  
	   
	}
   }
}