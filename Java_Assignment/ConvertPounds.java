import java.util.Scanner;
public class ConvertPounds{
  public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.print("Enter a number in pounds: ");
 double pounds = input.nextDouble();

double kilogram = pounds * 0.454;

System.out.printf("Conversion in kilogram %.3f", kilogram);
}

}