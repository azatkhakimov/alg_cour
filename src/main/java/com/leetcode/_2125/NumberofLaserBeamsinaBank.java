package main.java.com.leetcode._2125;

public class NumberofLaserBeamsinaBank {


    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;
        for (String s : bank) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1'){
                    count++;
                }
            }
            if(count > 0){
                ans += prev * count;
                prev = count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var n = new NumberofLaserBeamsinaBank();
        System.out.println(n.numberOfBeams(new String[]{"011001","000000","010100","001000"}));//Output: 8
        System.out.println(n.numberOfBeams(new String[]{"000","111","000"}));//Output: 0
    }
}
