package mine.jkchoi.leetcode;

import java.util.*;
import java.util.stream.Collectors;

//Result
//Runtime: 345 ms, faster than 15.01% of Java online submissions for 3Sum.
//Memory Usage: 54.2 MB, less than 5.29% of Java online submissions for 3Sum.
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<Integer> sortedList = Arrays.stream(nums).boxed().sorted(Integer::compareTo).collect(Collectors.toList());

        Integer[] sortedArray = new Integer[sortedList.size()];
        sortedList.toArray(sortedArray);

        final Set<Integer> numSet = sortedList.stream().collect(Collectors.toSet());

        if (numSet.size() < 10) {
            return threeSumSmallCase(sortedList, sortedArray);

        } else {
            return threeSumNormalCase(sortedArray, numSet);
        }
    }

    private List<List<Integer>> threeSumSmallCase(List<Integer> sortedList, Integer[] sortedArray) {
        List<Integer> distinctList = sortedList.stream().distinct().collect(Collectors.toList());

        List<List<Integer>> availableList = new ArrayList<>();

        final int length = distinctList.size();
        for(int i = 0; i < length; i++) {
            for (int j = i; j < length; j ++) {
                for(int k = j; k < length; k++) {
                    int first = distinctList.get(i);
                    int second = distinctList.get(j);
                    int third = distinctList.get(k);

                    if(first + second + third == 0) {
                        availableList.add(new ArrayList<>(Arrays.asList(first, second, third)));
                    }
                }
            }
        }

        final int sortedListSize = sortedList.size();
        return availableList.stream()
                .map(avVals -> {
                    final int avValSize = avVals.size();
                    int start = 0;
                    for(int i = 0; i < avValSize; i++) {
                        final int findingVal = avVals.get(i);

                        int findingIndex = -1;
                        for(int j = start; j < sortedListSize; j++) {
                            if(sortedList.get(j).equals(findingVal)) {
                                start = j + 1;
                                findingIndex = j;
                                break;
                            }
                        }

                        if(findingIndex < 0) {
                            return null;
                        }
                    }
                    return avVals;

                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<List<Integer>> threeSumNormalCase(Integer[] sortedArray, Set<Integer> numSet) {
        final List<List<Integer>> result = new ArrayList<>();

        final Set<List<Integer>> addedCheckSet = new HashSet<>();

        final int numsLength = sortedArray.length;
        for (int i = 0; i < numsLength - 2; i++) {
            for (int j = i + 1; j < numsLength - 1; j++) {
                int first = sortedArray[i];
                int second = sortedArray[j];
                int third = (first + second) * -1; // 찾는 값

                if (!numSet.contains(third)) {
                    continue;
                }

                List<Integer> addingCheckList = new ArrayList<>(Arrays.asList(first, second, third));
                addingCheckList.sort(Integer::compareTo);

                if (addedCheckSet.contains(addingCheckList)) {
                    continue;
                }

                int thirdIndex = Arrays.binarySearch(sortedArray, j + 1, numsLength, third);
                if (thirdIndex > 0) {
                    addedCheckSet.add(addingCheckList);

                    result.add(Arrays.asList(first, second, third));
                }
            }
        }

        return result;
    }
}
