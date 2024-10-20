import java.util.Scanner;
public class RaisedPower{
  public static void main(String[] args){
  
   Scanner input = new Scanner(System.in);

    System.out.print("Enter first number: ");
    int first_one = input.nextInt();
    System.out.print("Enter second number: ");
    int second_one = input.nextInt();

    int result = first_one * first_one;

    System.out.println(result);
  }
}