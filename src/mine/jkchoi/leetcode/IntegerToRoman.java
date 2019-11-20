package mine.jkchoi.leetcode;

public class IntegerToRoman {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};
        String[] symbols = new String[]{"I", "V", "X", "L", "C", "D", "M"};

        int[] otherValues = new int[]{1, 4, 9, 40, 90, 400, 900};
        String[] otherSymbols = new String[]{"", "IV", "IX", "XL", "XC", "CD", "CM"};

        StringBuilder result = new StringBuilder();

        int dividedVal = num;

        for (int i = symbols.length - 1; i >= 0; i--) {
            int dividingVal = values[i];
            int val = dividedVal / dividingVal;

            if (val > 0) {
                for (int j = 0; j < val; j++) {
                    result.append(symbols[i]);
                }
                dividedVal %= dividingVal;

            }

            int otherDivVal = otherValues[i];
            int otherVal = dividedVal / otherDivVal;
            if (otherVal > 0) {
                result.append(otherSymbols[i]);
                dividedVal -= otherDivVal;
            }
        }

        return result.toString();
    }
}
