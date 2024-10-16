import java.util.Scanner;
  public class Multiple{
    public static void main(String[] args){
     
    Scanner input = new Scanner(System.in);

    System.out.print("Enter first number: ");
    double numOne = input.nextDouble();

    System.out.print("Enter second number: ");
    double numTwo = input.nextDouble();

double result1 = numOne * numOne * numOne;
double result2 = numTwo * numTwo; 
    if (result2 % result1 == 0) {
       System.out.println("result two is a multiple!");
    } else {
       System.out.println("no!");
    }
}
}