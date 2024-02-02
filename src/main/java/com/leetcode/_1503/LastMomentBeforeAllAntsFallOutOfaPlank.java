package main.java.com.leetcode._1503;

public class LastMomentBeforeAllAntsFallOutOfaPlank {

    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int num : left) {
            ans = Math.max(ans, num);
        }

        for (int num : right) {
            ans = Math.max(ans, n - num);
        }
        return ans;
    }

    public static void main(String[] args) {
        var l = new LastMomentBeforeAllAntsFallOutOfaPlank();
        System.out.println(l.getLastMoment(4, new int[]{4,3}, new int[]{0,1}));//Output: 4
        System.out.println(l.getLastMoment(7, new int[]{}, new int[]{0,1,2,3,4,5,6,7}));//Output: 7
        System.out.println(l.getLastMoment(7, new int[]{0,1,2,3,4,5,6,7}, new int[]{}));//Output: 7
    }
}
