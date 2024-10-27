import java.util.Scanner;
public class Energy{
 public static void main(String[] args){

  Scanner input = new Scanner(System.in);

  System.out.print("Enter amount in water in kilogram: ");
  double kilogram = input.nextDouble();

  System.out.print("Enter initial temperature : ");
  double initialTemperature = input.nextDouble();

  System.out.print("Enter last temperature: ");
  double lastTemperature = input.nextDouble();

  double result = (lastTemperature - initialTemperature) * 4184;

  System.out.print(result);
 }
}