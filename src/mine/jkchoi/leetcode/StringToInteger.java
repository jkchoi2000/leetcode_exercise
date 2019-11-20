package mine.jkchoi.leetcode;

public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        String removedWhiteSpaceStr = str.trim();
        if(removedWhiteSpaceStr.isEmpty()) {
            return 0;
        }

        char firstChar = removedWhiteSpaceStr.charAt(0);
        if(firstChar != '+' && firstChar != '-' && !Character.isDigit(firstChar)) {
            return 0;
        }


        final String numStr = getNumberString(removedWhiteSpaceStr);
        if(numStr.isEmpty()) {
            return 0;
        }

        return parseString(numStr);
    }

    private String getNumberString(String str) {
        final StringBuilder strBuf = new StringBuilder();

        boolean startsZero = true;
        final int strLen = str.length();
        for(int i = 0; i < strLen; i++) {
            char ch = str.charAt(i);

            if(ch == '+' || ch == '-') {
                boolean isSignPos = (i == 0);
                if(isSignPos) {
                    strBuf.append(ch);
                    continue;
                } else {
                    break;
                }
            } else if(ch == '0') {
                if(startsZero) {
                    continue;
                }
                strBuf.append(ch);
            } else if(ch == '.') {
                break;
            } else if(!Character.isDigit(ch)) {
                break;
            } else {
                strBuf.append(ch);
            }

            startsZero = false;
        }

        return strBuf.toString();
    }

    private int parseString(String numStr) {
        int numStringLength = numStr.length();
        char firstChar = numStr.charAt(0);
        int startIndex = Character.isDigit(firstChar) ? 0 : 1;
        boolean isMinus = (startIndex > 0 && numStr.charAt(0) == '-');

        int maxValueStrLen = String.valueOf(Integer.MIN_VALUE).length();
        if(numStringLength > maxValueStrLen) {
            return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        long result = 0;
        long exp = 1;
        int maxExp =  numStringLength - startIndex;
        for(int i = 0; i < maxExp; i++) {
            result += ((numStr.charAt(numStringLength - i - 1) - '0') * exp);
            exp *= 10;
        }

        if(isMinus) {
            result *= -1;
        }

        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}
