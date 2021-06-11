package competitive.singhankit.leetcode.easy;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * <p>
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 * <p>
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 * <p>
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * @author _singhankit
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("1", "9"));
          System.out.println(new AddStrings().addStrings("456", "77"));
        System.out.println(new AddStrings().addStrings("584", "18"));
    }

    public String addStrings(String num1, String num2) {
        int[] numa = toIntegerArray(num1);
        int[] numb = toIntegerArray(num2);
        int length = Math.max(numa.length, numb.length);
        numa = appendZero(numa, length);
        numb = appendZero(numb, length);
        int[] result = new int[length];
        int remainder = 0;
        for (int i = length - 1; i >= 0; i--) {
            int c = numa[i] + numb[i] + remainder;
            if (c / 10 != 0) {
                result[i] = c % 10;
                remainder = c / 10;
            } else {
                remainder = 0;
                result[i] = c + remainder;
            }
        }
        if (remainder != 0)
            return remainder + toString(result);
        return toString(result);
    }

    private String toString(int[] array) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s += (array[i]);
        }
        return s;
    }

    private int[] appendZero(int[] array, int length) {
        if (array.length == length)
            return array;
        int[] newArray = new int[length];
        int k = newArray.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[k--] = array[i];
        }
        return newArray;
    }

    private int[] toIntegerArray(String num) {
        int length = num.length();
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = num.charAt(i) - '0';
        }
        return result;
    }

}
