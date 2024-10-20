public class PrintTable{
 public static void main(String[] args){
 int a = 1;
 int b = 0;
 double result = 0;
   System.out.println("a\tb\tpow(a, b)");
   while (a <= 5) {
      b = a + 1;
      result = Math.pow(a, b);
      System.out.printf("%d\t%d\t%.0f\n", a, b, result);
      a++;
   }
  }
}