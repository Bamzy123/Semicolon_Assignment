public class ConvertXO {
    public static String convert(char[] array){
        StringBuilder result = new StringBuilder();
        for (char c : array) {
            if (c == 'X' || c == 'x') {
                result.append(1);
            }else if (c == 'O' || c == 'o') {
                result.append(0);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        char[] inputArray = {'X', 'O', 'X', 'O', 'X', 'O', 'X'};

        String output = convert(inputArray);
        System.out.println("Converted output: " + output);
    }
}