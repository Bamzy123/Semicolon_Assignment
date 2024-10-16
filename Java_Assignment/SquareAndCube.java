public class SquareAndCube {
  public static void main(String[] args){
      int number1= 0;
      int square;
      int cube;
       
       System.out.println("number    square     cube");
      while (number1 <= 10) {
       square = number1 * number1;
       cube = number1 * number1 * number1;
        System.out.printf("%d          %d          %d%n", number1, square, cube);
       
       number1++;
}
} 

}