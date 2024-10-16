import java.util.Scanner;
public class CalculateInterest{

public static void main(String[] args){
Scanner input = new Scanner(System.in);
 
System.out.print("Enter balance: ");
double balance = input.nextDouble();

System.out.print("Enter annual percentage rate: ");
double annualPercentage = input.nextDouble();

double annualRate = balance * (annualPercentage/1200);
System.out.printf("%.2f", annualRate);
}

}