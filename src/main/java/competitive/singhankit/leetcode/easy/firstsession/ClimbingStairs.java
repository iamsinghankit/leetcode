package competitive.singhankit.leetcode.easy.firstsession;

/**
 * @author _singhankit
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().usingFibnocci(3));
        new ClimbingStairs().printFibnocciUsingRecursion(15);
       System.out.println(new ClimbingStairs().usingBruteForce(45));
        System.out.println(new ClimbingStairs().usingMemoization(45));
    }

    //0,1,1,2,3,5,8,13,21,34,55
    public void printFibnocciUsingRecursion(int n){
        System.out.print(1 + " " + 1 + " ");
        printFibnocci(n,1,1);
    }

    public void printFibnocci(int n,int pre1,int pre){
        int r= pre + pre1;
        System.out.print(r + " ");
        pre = pre1;
        pre1 = r;
        if(n<r)
            return;
        printFibnocci(n,pre1,pre);
    }
    public void printFibnocci(int n) {
        int pre = 1;
        int pre1 = 1;
        //System.out.print(pre + " " + pre1 + " ");
        int r=0;
        while(n>r){
            r = pre + pre1;
            System.out.print(r + " ");
            pre = pre1;
            pre1 = r;
        }

    }

    public int usingFibnocci(int n) {
            if (n == 0)
                return 1;
            if (n < 2)
                return n;
            return usingFibnocci(n - 1) + usingFibnocci(n - 2);
    }

    public int usingBruteForce(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    public int usingMemoization(int n) {
        int[] memo = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public int climb_Stairs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
