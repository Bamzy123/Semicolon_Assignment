import java.util.Scanner;
public class MortgageCalculator{
  public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      System.out.print("Enter principal loan amount: $");
      double principal = input.nextDouble();

      System.out.print("Enter annual interest rate: ");
      double annualInterestRate = input.nextDouble();

      System.out.print("Enter the duration of years: ");
      double durationOfYears = input.nextDouble();

      double annual = annualInterestRate / 100;
      double monthlyInterest = annual / 12;

      double totalPayment = durationOfYears * 12;

      double monthlyPayment = principal * monthlyInterest(1 + monthlyInterest)            math.pow(totalPayment)/(1 + monthlyInterest)math.pow(totalPayment) - 1;
  }
}