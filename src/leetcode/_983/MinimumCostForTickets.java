package leetcode._983;

public class MinimumCostForTickets {
    int[] days;
    int[] costs;
    Integer[] memo;
    int[] durations = new int[]{1,7,30};
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        return dp(0);
    }

    private int dp(int i) {
        if(i >= days.length){
            return 0;
        }
        if(memo[i] != null){
            return memo[i];
        }
        int ans = Integer.MAX_VALUE;
        int j = 1;
        for (int k = 0; k < 3; k++) {
            while (j < days.length && days[j] < days[i]+durations[k]){
                j++;
            }
            ans = Math.min(ans, dp(j)+costs[k]);
        }
        memo[i] = ans;
        return ans;
    }

    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        System.out.println(m.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));//Output: 11
        System.out.println(m.mincostTickets(new int[] {1,2,3,4,5,6,7,8,9,10,30,31}, new int[] {2,7,15}));//Output: 17
    }
}
