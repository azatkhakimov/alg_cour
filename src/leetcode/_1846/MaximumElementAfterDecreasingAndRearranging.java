package leetcode._1846;

public class MaximumElementAfterDecreasingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            int n = arr.length;
            int[] counts = new int[n+1];
            for (int num : arr) {
                counts[Math.min(num, n)]++;
            }
            int ans = 1;
            for (int num = 2; num <= n; num++) {
                ans = Math.min(ans+counts[num], num);
            }
            return ans;
    }
    public static void main(String[] args) {
        var m = new MaximumElementAfterDecreasingAndRearranging();
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));//Output: 2
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));//Output: 3
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));//Output: 5
    }
}
