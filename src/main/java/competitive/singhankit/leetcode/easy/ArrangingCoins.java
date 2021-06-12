package competitive.singhankit.leetcode.easy;

/**
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 * <p>
 * Given the integer n, return the number of complete rows of the staircase you will build.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * **
 * ** **
 * ** ** zz
 * <p>
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * <p>
 * **
 * ** **
 * ** ** **
 * ** ** zz zz
 * <p>
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 *
 * @author _singhankit
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(3));
        System.out.println(new ArrangingCoins().arrangeCoins(8));
        System.out.println(new ArrangingCoins().arrangeCoins(1));
        System.out.println(new ArrangingCoins().arrangeCoins(5));
    }

    public int arrangeCoins(int n) {
        if (n == 1)
            return n;
        int k = n;
        for (int i = 0; i < n; i++) {
            k = k - i - 1;
            if (k < 0)
                return i;
        }
        return 0;

    }
}
