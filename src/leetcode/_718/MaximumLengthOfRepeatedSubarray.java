package leetcode._718;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int answer = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    if (answer < dp[i][j]) {
                        answer = dp[i][j];
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}));//Output: 3
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(new int[]{0,0,0,0,0},
                new int[]{0,0,0,0,0}));//Output: 5
    }
}
