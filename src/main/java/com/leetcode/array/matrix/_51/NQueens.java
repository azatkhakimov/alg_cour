package main.java.com.leetcode.array.matrix._51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> solution = new ArrayList<>(Collections.nCopies(n, -1));
        solveNQueensReq(0, n, solution, ans);
        return ans;
    }

    private void solveNQueensReq(int currRow, int n, List<Integer> solution, List<List<Integer>> ans) {
        if(currRow == n){
            ans.add(solution);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(valid(currRow, i, solution)){
                solution.set(currRow, i);
                solveNQueensReq(currRow+1, n, solution, ans);
            }
        }
    }

    private boolean valid(int proposedRow, int proposedCol, List<Integer> solution) {
        int oldRow = 0;
        int oldCol = 0;
        int diagonalOffset = 0;
        for (int i = 0; i < proposedRow; i++) {
            oldRow = i;
            diagonalOffset = proposedRow - oldRow;
            oldCol = solution.get(i);
            if(oldCol == proposedCol || oldCol == proposedCol - diagonalOffset || oldCol == proposedCol+diagonalOffset){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    }
}
