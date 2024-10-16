import java.util.Scanner;

   public class Ques{
     public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.println("Enter your name: ");
	String name = input.nextLine();

	System.out.println("hi " + name + " nice to meet you");

	System.out.print("hi " + name + " nice to meet you\n");

	System.out.printf("%s", "hi " + name + " nice to meet you");
}
}