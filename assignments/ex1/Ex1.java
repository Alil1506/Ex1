package assignments.ex1;

/**
 * This class represents a simple solution for assignments.ex1.Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,G
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”, ”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    public static int charToInt(char z) {
        int ans = -1;
        char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == z) {
                ans = i;
            }

        }
        return ans;
    }


    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = 0;
        if (num.contains("b")) {
            String[] parts = num.split("b");
            if (parts.length != 2) {
                return -1;
            }
            int base = Integer.parseInt(parts[1]);
            String numWithoutBase = parts[0];
            StringBuilder numBuilder = new StringBuilder(numWithoutBase);
            numBuilder.reverse();
            String reversedNum = numBuilder.toString();
            for (int i = 0; i < reversedNum.length(); i++) {
                char currentChar = reversedNum.charAt(i);
                int value = charToInt(currentChar);
                if (value == -1 || value >= base) {
                    return -1;
                } else if (!num.contains("b")) {
                    System.out.println(parts[0]);
                }
                ans = ans + charToInt(currentChar) * (int) Math.pow(base, i);
            }
            return ans;
        }
        return ans;
    }
/**
 * This static function checks if the given String (g) is in a valid "number" format.
 *
 * @param a a String representing a number
 * @return true iff the given String is in a number format
 */
public static boolean isNumber(String a) {
    String chars = "23456789ABCDEFG";
    String chars2 = "0123456789";
    int lastB = a.lastIndexOf('b');
    boolean foundB = false;
    boolean ans = true;
    int count = 0;

    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) == 'b') {
            count++;
        }
        if (count > 1) {
            return false;
        }
    }
    if ((a == null) || a.isEmpty() || a.equals(" ")) {
        ans = false;
    }
    int baseInt;
    if (a.length() == 1) {
        return chars2.contains(a);
    }
    if (count == 1 && lastB == a.length() - 2) {
        String[] arr = a.split("b");
        String base = arr[1];
        String num = arr[0];
        if (arr[0].isEmpty()) {
            return false;
        }

        if (chars.contains(base)) {
            if (chars2.contains(base)) {
                baseInt = Integer.parseInt(base);
            } else {
                baseInt = Integer.parseInt(String.valueOf(base.charAt(0) - 55));
            }
            for (char c : num.toCharArray()) {
                int digitalValue = Character.isDigit(c)
                        ? c - '0'
                        : c - 'A' + 10;
                if (digitalValue < 0 || digitalValue >= baseInt) {
                    return false;
                }
            }
        } else {
            return false;
        }
    } else if (count == 0) {
        for (char c : a.toCharArray()) {
            int digitalValue = Character.isDigit(c)
                    ? c - '0'
                    : c - 'A' + 10;
            if (digitalValue < 0 || digitalValue >= 10) {
                return false;
            }


        }
    }

    return ans;
}

/**
 * Calculate the number representation (in basis base)
 * of the given natural number (represented as an integer).
 * If num<0 or base is not in [2,16] the function should return "" (the empty String).
 *
 * @param num  the natural number (include 0).
 * @param base the basis [2,16]
 * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
 */
public static String int2Number(int num, int base) {
    String ans = "";
    if (num < 0 || base < 2 || base > 16) {
        return "";
    }
    if (num == 0) {
        return "0";
    }

    char[] digits = "0123456789ABCDEF".toCharArray();

    StringBuilder result = new StringBuilder();


    while (num > 0) { //This loop repeatedly divide the number num by the given base and collect the remainder.
        result.insert(0, digits[num % base]); //
        num /= base;
    }


    return result.toString();
}


/**
 * Checks if the two numbers have the same value.
 *
 * @param n1 first number
 * @param n2 second number
 * @return true iff the two numbers have the same values.
 */
public static boolean equals(String n1, String n2) {
    boolean ans = true;
    int first = number2Int(n1);
    int second = number2Int(n2);
    if (first == second) {
        return ans;
    } else {
        return false;
    }

}

/**
 * This static function search for the array index with the largest number (in value).
 * In case there are more than one maximum - returns the first index.
 * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
 *
 * @param arr an array of numbers
 * @return the index in the array in with the largest number (in value).
 */
public static int maxIndex(String[] arr) {
    int ans = 0;


    return ans;
}
}
