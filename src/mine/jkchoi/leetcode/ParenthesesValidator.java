package mine.jkchoi.leetcode;

import java.util.*;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * Input: "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: "(]"
 * Output: false
 * <p>
 * Example 4:
 * Input: "([)]"
 * Output: false
 * <p>
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class ParenthesesValidator {
    private Set<Character> opens = new HashSet<>();
    private Set<Character> closes = new HashSet<>();
    private Map<Character, Character> pairs = new HashMap<>();

    public ParenthesesValidator() {
        opens.addAll(Arrays.asList('(', '{', '['));
        closes.addAll(Arrays.asList(')', '}', ']'));

        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> checker = new Stack<>();

        char[] parentheses = s.toCharArray();
        int len = parentheses.length;

        for (int i = 0; i < len; i++) {
            char parenthes = parentheses[i];

            if (opens.contains(parenthes)) {
                checker.push(parenthes);
            } else if (closes.contains(parenthes) && !checker.isEmpty()) {
                char popChar = checker.pop();
                if (pairs.get(parenthes) != popChar) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return checker.isEmpty();
    }
}
