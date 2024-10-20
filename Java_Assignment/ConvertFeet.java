import java.util.Scanner;

 public class ConvertFeet{
   public static void main(String[] args){
    
	Scanner input = new Scanner(System.in);

	System.out.print("Enter a value for feet: "); 
	double foot = input.nextDouble();

	double result = foot * 0.305;

	System.out.print(result);
   	}
}