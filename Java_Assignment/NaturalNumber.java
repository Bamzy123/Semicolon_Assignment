import java.util.Scanner;

public class NaturalNumber{
 public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int count = 1;
    int naturalNumber = 0;

    while(count < 11) {
    System.out.print("Enter a number: ");
    int number = input.nextInt();
   
    naturalNumber = naturalNumber + count;
    count+=1;
}
    System.out.printf("The numbers sum is: %d", naturalNumber);
  }
}