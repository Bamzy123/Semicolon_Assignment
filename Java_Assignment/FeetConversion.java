import java.util.Scanner;
public class FeetConversion{
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

System.out.print("Enter value of feet ");
  double feet = input.nextDouble();

double feetInMeter = feet * 0.305;

System.out.printf("feetInMeter %.4f", feetInMeter);
}

}