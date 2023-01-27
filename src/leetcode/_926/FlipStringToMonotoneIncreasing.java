package leetcode._926;

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int ans = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                ans = Math.min(num, ans+1);
            }else {
                num++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing string = new FlipStringToMonotoneIncreasing();
        System.out.println(string.minFlipsMonoIncr("00110"));//Output: 1
        System.out.println(string.minFlipsMonoIncr("010110"));//Output: 2
        System.out.println(string.minFlipsMonoIncr("00011000"));//Output: 2
    }
}
