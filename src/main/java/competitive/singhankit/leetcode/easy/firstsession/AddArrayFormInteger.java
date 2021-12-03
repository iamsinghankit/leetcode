package competitive.singhankit.leetcode.easy.firstsession;

import java.util.ArrayList;
import java.util.List;

/**
 * The array-form of an integer num is an array representing its digits in left to right order.
 * <p>
 * For example, for num = 1321, the array form is [1,3,2,1].
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = [1,2,0,0], k = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 * <p>
 * Input: num = [2,7,4], k = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 * <p>
 * Input: num = [2,1,5], k = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * Example 4:
 * <p>
 * Input: num = [9,9,9,9,9,9,9,9,9,9], k = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 *
 * @author _singhankit
 */
public class AddArrayFormInteger {
    public static void main(String[] args) {
        System.out.println(new AddArrayFormInteger().addToArrayForm(new int[]{2, 1, 5}, 806));
    }


    //Copied from AddStrings
    public List<Integer> addToArrayForm(int[] num, int k) {
        int[] num1 = toIntegerArray(k);
        int length = Math.max(num.length, num1.length);
        num = appendZero(num, length);
        num1 = appendZero(num1, length);
        int[] result = new int[length];
        int remainder = 0;
        for (int i = length - 1; i >= 0; i--) {
            int c = num[i] + num1[i] + remainder;
            if (c / 10 != 0) {
                result[i] = c % 10;
                remainder = c / 10;
            } else {
                remainder = 0;
                result[i] = c + remainder;
            }
        }
        String finalResult = "";
        if (remainder != 0) {
            finalResult = remainder + toString(result);
        } else {
            finalResult = toString(result);
        }
        return toList(toIntegerArray(finalResult));
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

    private int[] toIntegerArray(int k) {
        return toIntegerArray(String.valueOf(k));

    }

    private int[] toIntegerArray(String num) {
        int length = num.length();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = num.charAt(i) - '0';
        }
        return result;
    }

    private List<Integer> toList(int[] array) {
        List list = new ArrayList();
        for (int i : array)
            list.add(i);
        return list;
    }

}
