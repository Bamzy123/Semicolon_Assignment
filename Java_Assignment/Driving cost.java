import java.util.Scanner;
 public class DrivingCost{
public static void main(String[] args){

   Scanner input = new Scanner(System.in);

System.out.print("Enter driving distance: ");
   double distance = input.nextDouble();


System.out.print("Enter miles per gallon: ");
   double gallon = input.nextDouble();

System.out.print("Enter price per gallon: ");
   double price = input.nextDouble();

double drivingCost = (distance * price) / gallon;

System.out.print(drivingCost);
}

}