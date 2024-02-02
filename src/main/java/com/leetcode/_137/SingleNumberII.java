package main.java.com.leetcode._137;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += num >> i & 1;

            }
            sum %= 3;
            ans |= sum << i;
        }
        return ans;
    }

    public static void main(String[] args) {
        var s = new SingleNumberII();
        System.out.println(s.singleNumber(new int[]{2,2,3,2}));//Output: 3
        System.out.println(s.singleNumber(new int[]{0,1,0,1,0,1,99}));//Output: 99
    }
}
