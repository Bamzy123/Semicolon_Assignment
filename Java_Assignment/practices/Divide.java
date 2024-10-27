import java.util.Scanner;
public class Divide{
  public static void main(String[] args){

  Scanner input = new Scanner(System.in);

  System.out.print("Enter number: ");
  int number = input.nextInt();

  int number_one = 3;

  if (number % number_one == 0){
      System.out.printf("this number is divisible by 3");
      }
  else
      System.out.print("not divisible by three");
   }
}