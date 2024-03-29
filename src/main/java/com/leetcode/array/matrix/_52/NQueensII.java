package main.java.com.leetcode.array.matrix._52;

public class NQueensII {
    public int totalNQueens(int n) {
        if(n == 0){
            return n;
        }
        int[] q = new int[n];
        return track(q, 0);

    }

    private int track(int[] q, int row) {
        if(row == q.length){
            return 1;
        }
        int solution = 0;
        for (int i = 0; i < q.length; i++) {
            q[row] = i;
            if(isValid(q, row, i)){
                solution += track(q, row+1);
            }
        }
        return solution;
    }

    private boolean isValid(int[] q, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(q[i] == col || Math.abs(row-i) == Math.abs(col - q[i])){
                return false;
            }
        }
        return true;
    }
}
