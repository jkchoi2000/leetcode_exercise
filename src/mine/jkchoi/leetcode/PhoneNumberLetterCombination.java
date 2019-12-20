package mine.jkchoi.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Title : 17. Letter Combinations of a Phone Number
 * <p>
 * Description
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class PhoneNumberLetterCombination {
    private final Map<Character, Character[]> numberLetters = new HashMap<>();

    public PhoneNumberLetterCombination() {
        numberLetters.put('2', new Character[]{'a', 'b', 'c'});
        numberLetters.put('3', new Character[]{'d', 'e', 'f'});
        numberLetters.put('4', new Character[]{'g', 'h', 'i'});
        numberLetters.put('5', new Character[]{'j', 'k', 'l'});
        numberLetters.put('6', new Character[]{'m', 'n', 'o'});
        numberLetters.put('7', new Character[]{'p', 'q', 'r', 's'});
        numberLetters.put('8', new Character[]{'t', 'u', 'v'});
        numberLetters.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<Character[]> letters = digits.chars()
                .mapToObj(ch -> (char) ch)
                .map(numberLetters::get)
                .collect(Collectors.toList());

        if (letters.isEmpty()) {
            return Collections.emptyList();
        }

        final int resultSize = letters.stream().mapToInt(arr -> arr.length).reduce(1, (s1, s2) -> s1 * s2);

        final Character[][] resultArray = new Character[resultSize][letters.size()];

        func(resultArray, 0, resultSize, letters, 0);

        return Arrays.stream(resultArray)
                .map(charArr -> Arrays.stream(charArr)
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
    }

    private void func(Character[][] array, int start, int end, List<Character[]> lettersList, int digitIndex) {
        if (digitIndex >= lettersList.size()) {
            return;
        }

        final Character[] letters = lettersList.get(digitIndex);
        final int letterCnt = letters.length;
        final int sizePerLetter = (end - start) / letterCnt;
        final int nextDigitIndex = digitIndex + 1;

        for (int i = 0; i < letterCnt; i++) {
            final Character letter = letters[i];
            final int subStart = start + (i * sizePerLetter);

            for (int j = 0; j < sizePerLetter; j++) {
                array[subStart + j][digitIndex] = letter;
            }

            func(array, subStart, subStart + sizePerLetter, lettersList, nextDigitIndex);
        }
    }
}
