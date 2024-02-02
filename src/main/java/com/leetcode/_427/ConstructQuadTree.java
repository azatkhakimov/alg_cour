package main.java.com.leetcode._427;

public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    private Node solve(int[][] grid, int x1, int y1, int length) {
        if(length == 1){
            return new Node(grid[x1][y1] == 1, true);
        }
        Node topLeft = solve(grid, x1, y1, length/2);
        Node topRight = solve(grid, x1, y1+length/2, length/2);
        Node bottomLeft = solve(grid, x1+length/2, y1, length/2);
        Node bottomRight = solve(grid, x1+length/2, y1+length/2, length/2);

        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf
        && bottomRight.isLeaf && topLeft.val == topRight.val &&
        topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val){
            return new Node(topLeft.val, true);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static void main(String[] args) {
        ConstructQuadTree c = new ConstructQuadTree();
        System.out.println(c.construct(new int[][]{
                {0, 1},
                {1, 0}
        }));//Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
        System.out.println(c.construct(new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        }));//Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
    }
}
