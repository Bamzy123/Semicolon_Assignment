import java.util.Scanner;
 public class Geometry {
   public static void main(String[] args){
   
    Scanner input = new Scanner(System.in);	
    
    System.out.println("Enter point one: ");
    double num1 = input.nextDouble();
    System.out.println("Enter point one: ");
    double num2 = input.nextDouble();
    double side1 = num1 + num2;

    System.out.println("Enter point two: ");
    double num3 = input.nextDouble();
    System.out.println("Enter point two: ");
    double num4 = input.nextDouble();
    double side2 = num3 + num4;

    System.out.println("Enter point three: ");
    double num5 = input.nextDouble();
    System.out.println("Enter point three: ");
    double num6 = input.nextDouble();
    double side3 = num5 + num6;

	double result = (side1 + side2 + side3) / 2;
	double result2= result * (result - side1) * (result - side2) *  (result - side3);
	double result3 = Math.sqrt(result2);

	System.out.print(result3);
}
}