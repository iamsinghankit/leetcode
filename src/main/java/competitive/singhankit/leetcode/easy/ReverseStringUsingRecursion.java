package competitive.singhankit.leetcode.easy;

/**
 * @author _singhankit
 */
public class ReverseStringUsingRecursion {


    public static void main(String[] args) {
        new ReverseStringUsingRecursion().reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    public void reverseString(char[] s) {
        reverse(s, 1);
    }

    public void reverse(char[] s, int j) {
        if (s.length < j)
            return;
        System.out.print(s[s.length - j++]);
        reverse(s, j);
    }

}
