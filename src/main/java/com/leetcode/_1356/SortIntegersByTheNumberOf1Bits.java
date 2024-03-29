package main.java.com.leetcode._1356;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumberOf1Bits {

    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        var s = new SortIntegersByTheNumberOf1Bits();
        //System.out.println(s.sortByBits());
    }

    class CustomComparator implements Comparator<Integer> {

        private int findWeight(int num) {
            int weight = 0;
            while (num > 0) {
                weight++;
                num &= (num - 1);
            }
            return weight;
        }

        @Override
        public int compare(Integer a, Integer b) {
            if (findWeight(a) == findWeight(b)) {
                return a - b;
            }
            return findWeight(a) - findWeight(b);
        }
    }
}
