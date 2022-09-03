package leetcode._967;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        List<Integer> queue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int level = 1; level < n; level++) {
            ArrayList<Integer> nextQueue = new ArrayList<>();
            for (Integer num : queue) {
                Integer tailDigit = num % 10;

                ArrayList<Integer> nextDigits = new ArrayList<>();
                nextDigits.add(tailDigit + k);
                if (k != 0)
                    nextDigits.add(tailDigit - k);
                for (Integer nextDigit : nextDigits) {
                    if (0 <= nextDigit && nextDigit < 10) {
                        Integer newNum = num * 10 + nextDigit;
                        nextQueue.add(newNum);
                    }
                }
            }
            queue = nextQueue;
        }
        return queue.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences test = new NumbersWithSameConsecutiveDifferences();
        System.out.println(Arrays.toString(test.numsSameConsecDiff(3, 7)));//Output: [181,292,707,818,929]
        System.out.println(Arrays.toString(test.numsSameConsecDiff(2, 1)));//Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
    }
}
