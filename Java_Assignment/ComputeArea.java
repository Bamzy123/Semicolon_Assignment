//The program declares radius and area as variables. The reserved word double indicates that radius and area are floating-point values stored in the computer//


import java.util.Scanner;
 public class ComputeArea{
        public static void main(String[] args){
        Scanner input = new Scanner(System.in);	

	System.out.print("Designate circle's radius: ");
        double radius = input.nextDouble();				
        
         radius = 50 ;								double area = radius * radius * 3.14159;													System.out.println("The area for the circle of radius " + radius + " is " + area);

            System.out.println("\"Courage must come from the soul within\"");
}

}