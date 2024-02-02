package main.java.com.leetcode._997;

public class FindTheTownJudge {


    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if(count[i] == n-1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge judge = new FindTheTownJudge();
        System.out.println(judge.findJudge(2, new int[][] {{1,2}}));//Output: 2
        System.out.println(judge.findJudge(3, new int[][] {{1,3},{2,3}}));//Output: 3
        System.out.println(judge.findJudge(3, new int[][] {{1,3},{2,3},{3,1}}));//Output: -1
    }
}
