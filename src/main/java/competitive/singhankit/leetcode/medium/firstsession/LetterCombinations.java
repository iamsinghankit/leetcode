package competitive.singhankit.leetcode.medium.firstsession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 * @author _singhankit
 */
public class LetterCombinations {

    static Map<Character, String> letters = Map.of('2', "abc", '3', "def",
            '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");


    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();
        System.out.println(combinations.letterCombinations("2349"));
    }

    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if (digits.length() == 0)
            return result;
        backtrack(0, "", digits, result);
        return result;
    }

    private void backtrack(int i, String curStr, String digits, List result) {
        if (curStr.length() == digits.length()) {
            result.add(curStr);
            return;
        }
        for (char c : letters.get(digits.charAt(i)).toCharArray())
            backtrack(i + 1, curStr + c, digits, result);
    }


}
