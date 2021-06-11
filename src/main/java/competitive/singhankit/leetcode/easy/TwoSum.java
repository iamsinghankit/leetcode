package competitive.singhankit.leetcode.easy;


/**
 * Input: nums = [2,7,11,15], target = 9
 *         Output: [0,1]
 *         Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * @author _singhankit
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int length=nums.length;
        int result[] = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int a = nums[i] + nums[j];
                if (a == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        return null;
    }
}