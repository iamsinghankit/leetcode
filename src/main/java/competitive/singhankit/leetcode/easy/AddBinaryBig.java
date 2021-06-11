package competitive.singhankit.leetcode.easy;

import java.math.BigInteger;

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
public class AddBinaryBig {
    public static void main(String[] args) {
        System.out.println(new AddBinaryBig().addBinary("11", "1"));
        System.out.println(new AddBinaryBig().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        BigInteger a1 = binaryToDecimal(a);
        BigInteger b1 = binaryToDecimal(b);
        BigInteger sum=a1.add(b1);
        return decimalToBinary(sum);
    }

    private String decimalToBinary(BigInteger value) {
        StringBuilder builder = new StringBuilder();
        BigInteger two=BigInteger.TWO;
        while (!((value.divide(two)).equals( BigInteger.ZERO))) {
            BigInteger r = value.mod(two);
            value = value.divide(two) ;
            builder.append(r);
        }
        builder.append(value);
        return builder.reverse()
                      .toString();
    }

    private BigInteger binaryToDecimal(String value) {
        BigInteger result = BigInteger.ZERO;
        int length = value.length();
        int actualIndex=length-1;
        for (int i = actualIndex; i >= 0; i--) {
            if (value.charAt(i) == '1') {
                result=result.add(pow(actualIndex-i));
            }
        }
        return result;
    }

    private BigInteger pow(int b){
        return BigInteger.TWO.pow(b);
    }
}
