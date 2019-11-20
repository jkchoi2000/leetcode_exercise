package mine.jkchoi.leetcode;

public class RomanToInteger {
    //Result
    //Runtime: 5 ms, faster than 59.28% of Java online submissions for Roman to Integer.
    //Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Roman to Integer.
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};
        String[] symbols = new String[]{"I", "V", "X", "L", "C", "D", "M"};

        int[] otherValues = new int[]{1, 4, 9, 40, 90, 400, 900};
        String[] otherSymbols = new String[]{"", "IV", "IX", "XL", "XC", "CD", "CM"};

        int result = 0;
        int searchIndex = symbols.length - 1;
        int strLength = s.length();

        for (int i = 0; i < strLength;) {
            String indexStr = String.valueOf(s.charAt(i));

            while (searchIndex >= 0) {
                if (indexStr.equals(symbols[searchIndex])) {
                    result += values[searchIndex];
                    i++;
                    break;
                }

                if(i < (strLength - 1)) {
                    String twoStr = s.substring(i, i + 2);
                    if (twoStr.equals(otherSymbols[searchIndex])) {
                        result += otherValues[searchIndex];
                        i += 2;
                        break;
                    }
                }

                searchIndex--;

            }
        }

        return result;
    }
}
