import java.util.Scanner;

public class Total{
 public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int count = 1;
    int num = 0;
    int total_num = 0;

    while(count < 11) {
    System.out.print("Enter a number: ");
    int number1 = input.nextInt();
   
    total_num = total_num + count;
    count+=1;
}
    System.out.printf("The numbers sum is: %d", total_num);
  }
}