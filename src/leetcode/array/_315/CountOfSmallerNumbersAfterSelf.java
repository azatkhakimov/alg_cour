package leetcode.array._315;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        int n = nums.length;
        int[] result = new int[n];

        ArrayValWithOrigIdx[] newNums = new ArrayValWithOrigIdx[n];
        for (int i = 0; i < n; i++) {
            newNums[i] = new ArrayValWithOrigIdx(nums[i], i);
        }
        mergeSortAndCount(newNums, 0, n-1, result);
        List<Integer> resultList = new LinkedList<>();
        for (int i : result) {
            resultList.add(i);
        }
        
        return resultList;
    }

    private void mergeSortAndCount(ArrayValWithOrigIdx[] newNums, int start, int end, int[] result) {
        if(start >= end){
            return;
        }

        int mid = start+(end-start)/2;
        mergeSortAndCount(newNums, start, mid, result);
        mergeSortAndCount(newNums, mid+1, end, result);

        int leftPos = start;
        int rightPos = mid+1;
        LinkedList<ArrayValWithOrigIdx> merged = new LinkedList<>();
        int numElemsRightArrayLessThanLeftArray = 0;
        while (leftPos < mid+1 && rightPos <= end){
            if (newNums[leftPos].val > newNums[rightPos].val) {
                ++numElemsRightArrayLessThanLeftArray;
                merged.add(newNums[rightPos++]);
            } else {
                result[newNums[leftPos].originalIdx] += numElemsRightArrayLessThanLeftArray;
                merged.add(newNums[leftPos++]);
            }
        }

        while (leftPos <  mid +1) {
            result[newNums[leftPos].originalIdx]+= numElemsRightArrayLessThanLeftArray;
            merged.add(newNums[leftPos++]);
        }

        while (rightPos <= end){
            merged.add(newNums[rightPos++]);
        }

        int pos = start;
        for (ArrayValWithOrigIdx arrayValWithOrigIdx : merged) {
            newNums[pos++] = arrayValWithOrigIdx;
        }

    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf test = new CountOfSmallerNumbersAfterSelf();
        System.out.println(test.countSmaller(new int[]{5,2,6,1}));//Output: [2,1,1,0]
        System.out.println(test.countSmaller(new int[]{-1,-1}));//Output: [0,0]
    }

    private class ArrayValWithOrigIdx {
        int val;
        int originalIdx;

        public ArrayValWithOrigIdx(int val, int originalIdx) {
            this.val = val;
            this.originalIdx = originalIdx;
        }
    }
}
