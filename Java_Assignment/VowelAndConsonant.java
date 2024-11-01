import java.util.Scanner;

public class VowelAndConsonant{
	public static void main(String... args) {

		Scanner input = new Scanner(System.in);

		System.out.print("enter a letter: ");
		String letter = input.nextLine();


		if (letter.length() == 1) {
			if (letter.matches("[a-zA-Z]+")) {

				if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")) 		
				{
					System.out.printf("%s is a vowel letter", letter);
				} 

				else {
					System.out.printf("%s is a consonant letter", letter);
				}

			}
			
			else {
				System.out.printf("%s is an integer", letter);
			}
	

		}

		else {
			System.out.println("length is more than one");
		}

	}
}