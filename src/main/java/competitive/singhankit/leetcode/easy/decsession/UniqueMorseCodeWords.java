package competitive.singhankit.leetcode.easy.decsession;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author _singhankit
 */
public class UniqueMorseCodeWords {


    private static final Map<Character, String> MORSE_CODE = new HashMap<>(26);

    static {
        MORSE_CODE.put('a', ".-");
        MORSE_CODE.put('b', "-...");
        MORSE_CODE.put('c', "-.-.");
        MORSE_CODE.put('d', "-..");
        MORSE_CODE.put('e', ".");
        MORSE_CODE.put('f', "..-.");
        MORSE_CODE.put('g', "--.");
        MORSE_CODE.put('h', "....");
        MORSE_CODE.put('i', "..");
        MORSE_CODE.put('j', ".---");
        MORSE_CODE.put('k', "-.-");
        MORSE_CODE.put('l', ".-..");
        MORSE_CODE.put('m', "--");
        MORSE_CODE.put('n', "-.");
        MORSE_CODE.put('o', "---");
        MORSE_CODE.put('p', ".--.");
        MORSE_CODE.put('q', "--.-");
        MORSE_CODE.put('r', ".-.");
        MORSE_CODE.put('s', "...");
        MORSE_CODE.put('t', "-");
        MORSE_CODE.put('u', "..-");
        MORSE_CODE.put('v', "...-");
        MORSE_CODE.put('w', ".--");
        MORSE_CODE.put('x', "-..-");
        MORSE_CODE.put('y', "-.--");
        MORSE_CODE.put('z', "--..");
    }


    public static void main(String[] args) {
        String[] input = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(input));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> morseCodes = new HashSet<>(words.length);
        for (String word : words) {
            morseCodes.add(intoMorse(word));
        }
        return morseCodes.size();
    }

    private static String intoMorse(String value) {
        String result = "";
        for (Character c : value.toCharArray()) {
            result += MORSE_CODE.get(c);
        }
        return result;
    }


}
