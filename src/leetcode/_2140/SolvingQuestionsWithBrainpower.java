package leetcode._2140;

public class SolvingQuestionsWithBrainpower {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long [] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        for (int i = n-2; i >= 0; i--) {
            dp[i] = questions[i][0];
            int skip = questions[i][1];
            if(i+skip+1 < n){
                dp[i] += dp[i+skip+1];
            }
            dp[i] = Math.max(dp[i], dp[i+1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        var s = new SolvingQuestionsWithBrainpower();
        System.out.println(s.mostPoints(new int[][]{
                {3,2},{4,3},{4,4},{2,5}
        }));//Output: 5
        System.out.println(s.mostPoints(new int[][]{
                {1,1},{2,2},{3,3},{4,4},{5,5}
        }));//Output: 7
    }
}
