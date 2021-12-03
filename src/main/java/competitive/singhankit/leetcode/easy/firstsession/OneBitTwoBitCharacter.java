package competitive.singhankit.leetcode.easy.firstsession;

/**
 * We have two special characters:
 * <p>
 * The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 * Given a binary array bits that ends with 0, return true if the last character must be a one-bit character
 * <p>
 * Input: bits = [1,0,0]
 * Output: true
 * Explanation: The only way to decode it is two-bit character and one-bit character.
 * So the last character is one-bit character.
 * <p>
 * Input: bits = [1,1,1,0]
 * Output: false
 * Explanation: The only way to decode it is two-bit character and two-bit character.
 * So the last character is not one-bit character.
 *
 * @author _singhankit
 */
public class OneBitTwoBitCharacter {
    public static void main(String[] args) {
        System.out.println(new OneBitTwoBitCharacter().isOneBitCharacter(new int[]{1,0,0}));
        System.out.println(new OneBitTwoBitCharacter().isOneBitCharacter(new int[]{1,1,1,0}));
    }

    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        boolean oneBit = false;
        for (int i = 0; i < length; ) {
            if (bits[i] == 0) {
                oneBit = true;
                i++;
            } else {
                oneBit = false;
                i = i + 2;
            }
        }
        return oneBit;
    }
}
