package mine.jkchoi.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int mostWater = 0;

        //Best
        //Runtime: 2 ms, faster than 95.25% of Java online submissions for Container With Most Water.
        //Memory Usage: 40.3 MB, less than 90.38% of Java online submissions for Container With Most Water.
        int left = 0;
        int right = height.length - 1;
        int distance = 0;

        while (left < right) {
            distance = right - left;
            int leftVal = height[left];
            int rightVal = height[right];
            int minVal = (leftVal < rightVal) ? leftVal : rightVal;

            mostWater = (mostWater > (minVal * distance)) ? mostWater : (minVal * distance);

            if(leftVal < rightVal) {
                left++;
            } else {
                right--;
            }
        }


        // SoSo
        //Runtime: 203 ms, faster than 21.79% of Java online submissions for Container With Most Water.
        //Memory Usage: 40.5 MB, less than 76.28% of Java online submissions for Container With Most Water.
//        int startValue = 0;
//        int distance = 0;
//
//        final int arrLen = height.length;
//        for(int i = 0; i < arrLen - 1; i++) {
//            startValue = height[i];
//
//            for(int j = i + 1; j < arrLen; j++) {
//                distance = j - i;
//                int endValue = height[j];
//                int calVal = ((startValue > endValue) ? endValue : startValue) * distance;
//                mostWater = (mostWater > calVal) ? mostWater : calVal;
//            }
//        }

        return mostWater;
    }
}
