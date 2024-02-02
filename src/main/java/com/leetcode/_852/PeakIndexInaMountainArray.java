package main.java.com.leetcode._852;

public class PeakIndexInaMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        while (lo < hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid] < arr[mid+1]){
                lo = mid+1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        PeakIndexInaMountainArray peak = new PeakIndexInaMountainArray();
        System.out.println(peak.peakIndexInMountainArray(new int[]{0,1,0}));//Output: 1
        System.out.println(peak.peakIndexInMountainArray(new int[]{0,2,1,0}));//Output: 1
        System.out.println(peak.peakIndexInMountainArray(new int[]{0,10,5,2}));//Output: 1
    }
}
