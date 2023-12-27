package leetcode._1582;

public class SpecialPositionsInaBinaryMatrix {


    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(mat[row][col] == 1){
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }
        int ans = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(mat[row][col] == 1){
                    if(rowCount[row] == 1 &&  colCount[col] == 1){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        var s = new SpecialPositionsInaBinaryMatrix();
        System.out.println(s.numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));//Output: 1
        System.out.println(s.numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));//Output: 3
    }
}
