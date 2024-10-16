import java.util.Scanner;
 public class Acceleration{
   public static void main(String[] args){

  Scanner input = new Scanner(System.in);
   System.out.print("Enter initial velocity: ");
double initial = input.nextDouble();

 System.out.print("Enter final velocity: ");
double speed = input.nextDouble();

 System.out.print("Enter time: ");
double time = input.nextDouble();

double result = (speed - initial) / time;

System.out.printf("The average acceleration is %.4f", result);
}


}