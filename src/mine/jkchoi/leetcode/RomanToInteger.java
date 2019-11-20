package mine.jkchoi.leetcode;

public class RomanToInteger {
    public int romanToInt(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }

        int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};
        String[] symbols = new String[]{"I", "V", "X", "L", "C", "D", "M"};

        int[] otherValues = new int[]{1, 4, 9, 40, 90, 400, 900};
        String[] otherSymbols = new String[]{"", "IV", "IX", "XL", "XC", "CD", "CM"};

    }
}
