import mine.jkchoi.leetcode.ContainerWithMostWater;
import mine.jkchoi.leetcode.StringToInteger;

public class Main {

    public static void main(String[] args) {

//        StringToInteger stringToInteger = new StringToInteger();
//        System.out.println(stringToInteger.myAtoi("   -  "));
//        System.out.println(stringToInteger.myAtoi("   -43  "));
//        System.out.println(stringToInteger.myAtoi("4193 with words"));
//        System.out.println(stringToInteger.myAtoi("words and 987"));
//        System.out.println(stringToInteger.myAtoi("-91283472332"));
//        System.out.println(stringToInteger.myAtoi("+-2"));
//        System.out.println(stringToInteger.myAtoi("010"));

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
