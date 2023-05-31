package leetcode._136;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            answer ^= num;
        }
        return answer;
    }

    public static void main(String[] args) {
        var s = new SingleNumber();
        System.out.println(s.singleNumber(new int[]{2,2,1}));//Output: 1
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));//Output: 4
        System.out.println(s.singleNumber(new int[]{1}));//Output: 1
    }
}
