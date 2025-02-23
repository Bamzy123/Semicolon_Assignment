package SevenSegment;

import java.util.Arrays;
import java.util.Scanner;

public class SevenSegmentDisplay {

    public static char[][] getSevenSegmentDisplay(int digit) {
        if (digit < 0 || digit > 9) throw new IllegalArgumentException("Digit must be between 0 and 9");

        char[][] display = new char[5][4];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(display[i], ' ');
        }

        boolean[] segments = getBooleans(digit);

        if (segments[0]) {
            for (int col = 0; col < 4; col++) display[0][col] = '#';
        }

        if (segments[6]) {
            for (int col = 0; col < 4; col++) display[2][col] = '#';
        }

        if (segments[3]) {
            for (int col = 0; col < 4; col++) display[4][col] = '#';
        }

        if (segments[1]) display[1][3] = '#';

        if (segments[2]) display[3][3] = '#';

        if (segments[5]) display[1][0] = '#';

        if (segments[4]) display[3][0] = '#';

        if (digit == 7) display[4][3] = '#';

        return display;
    }

    private static boolean[] getBooleans(int digit) {
        boolean[][] digitToSegment = {

                { true,  true,  true,  true,  true,  true,  false },
                { false, true,  true,  false, false, false, false },
                { true,  true,  false, true,  true,  false, true  },
                { true,  true,  true,  true,  false, false, true  },
                { false, true,  true,  false, false, true,  true  },
                { true,  false, true,  true,  false, true,  true  },
                { true,  false, true,  true,  true,  true,  true  },
                { true,  true,  true,  false, false, false, false },
                { true,  true,  true,  true,  true,  true,  true  },
                { true,  true,  true,  true,  false, true,  true  }
        };

        return digitToSegment[digit];
    }

    public static void printDisplay(char[][] display) {
        for (char[] row : display) System.out.println(new String(row));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a digit (0-9): ");
        int digit = sc.nextInt();

        try {
            char[][] display = getSevenSegmentDisplay(digit);
            printDisplay(display);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }

        sc.close();
    }
}
