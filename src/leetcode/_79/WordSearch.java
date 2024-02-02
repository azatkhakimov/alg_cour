package leetcode._79;

//DFS
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(row, col, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word) {
        if (word.isEmpty()) {
            return true;
        }

        if (row < 0 || row == board.length || col < 0 || col == board[0].length || (board[row][col] != word.charAt(0))) {
            return false;
        }
        boolean result = false;

        board[row][col] = '*';
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int rowDir = dir[0];
            int colDir = dir[1];
            result = dfs(row + rowDir, col + colDir, board, word.substring(1));
        }
        board[row][col] = word.charAt(0);
        return result;
    }


    public static void main(String[] args) {
        var w = new WordSearch();
        //System.out.println(w.dfs());
    }
}
