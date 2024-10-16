import java.util.Scanner;
  public class Temperature{
public static void main(String[] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter amount of water: ");
double water = input.nextDouble();

System.out.print("Enter initial temperature: ");
double initial = input.nextDouble();

System.out.print("Enter final temperature: ");
double answer = input.nextDouble();

double Temp = water * (answer - initial) * 4184;

System.out.println(Temp);

}

}