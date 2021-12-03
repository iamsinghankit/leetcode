package competitive.singhankit.leetcode.easy.firstsession;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * @author _singhankit
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int a1 = binaryToDecimal(a);
        int b1 = binaryToDecimal(b);
        return decimalToBinary(a1 + b1);
    }

    private String decimalToBinary(int value) {
        StringBuilder builder = new StringBuilder();
        while (value / 2 != 0) {
            int r = value % 2;
            value = value / 2;
            builder.append(r);
        }
        builder.append(value);
        return builder.reverse()
                      .toString();
    }

    private int binaryToDecimal(String value) {
        int result = 0;
        int length = value.length();
        int actualIndex=length-1;
        for (int i = actualIndex; i >= 0; i--) {
            if (value.charAt(i) == '1') {
                result += Math.pow(2, actualIndex - i);
            }
        }
        return result;
    }
}
