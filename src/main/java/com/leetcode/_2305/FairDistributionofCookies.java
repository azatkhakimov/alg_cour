package main.java.com.leetcode._2305;

public class FairDistributionofCookies {


    public int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];
        return dfs(0, distribute, cookies, k, k);
    }

    private int dfs(int i, int[] distribute, int[] cookies, int k, int zeroCount) {
        if(cookies.length - i < zeroCount){
            return Integer.MAX_VALUE;
        }
        if (i == cookies.length) {
            int unfairness = Integer.MIN_VALUE;
            for (int value : distribute) {
                unfairness = Math.max(unfairness, value);
            }
            return unfairness;
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            zeroCount -= distribute[j] == 0 ? 1 : 0;
            distribute[j] += cookies[i];
            ans = Math.min(ans, dfs(i+1,distribute, cookies, k, zeroCount));
            distribute[j] -= cookies[i];
            zeroCount += distribute[j] == 0 ? 1: 0;

        }

        return ans;
    }


    public static void main(String[] args) {
        var f = new FairDistributionofCookies();
        System.out.println(f.distributeCookies(new int[]{8,15,10,20,8}, 2));//Output: 31
        System.out.println(f.distributeCookies(new int[]{6,1,3,2,2,4,1,2}, 3));//Output: 7
    }
}
