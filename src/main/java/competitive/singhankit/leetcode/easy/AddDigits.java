package competitive.singhankit.leetcode.easy;

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * Example 2:
 * <p>
 * Input: num = 0
 * Output: 0
 *
 * @author _singhankit
 */
public class AddDigits {
    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
        System.out.println(new AddDigits().addDigits(0));
    }

    public int addDigits(int num) {
        int result = 0;
        while (hasDigits(num)) {
            int div = num / 10;
            result = +div;
            num = num % 10;
        }
        result += num;
        return hasDigits(result) ? addDigits(result) : result;
    }

    private boolean hasDigits(int num) {
        return num / 10 != 0;
    }
}
