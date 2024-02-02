package main.java.com.leetcode.array._318._88;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex1 = m-1;
        int lastIndex2 = n-1;
        int last = m+n-1;
        while (lastIndex1 >=0 && lastIndex2 >= 0){
            if(nums1[lastIndex1] > nums2[lastIndex2]){
                nums1[last] = nums1[lastIndex1];
                last--;
                lastIndex1--;
            }else {
                nums1[last] = nums2[lastIndex2];
                last--;
                lastIndex2--;
            }
        }
        while (lastIndex2 >=0){
            nums1[last] = nums2[lastIndex2];
            last--;
            lastIndex2--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
    }
}
