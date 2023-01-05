package leetcode._1339;

public class MaximumProductOfSplittedBinaryTree {
    long ans = 0;
    long totalSum = 0;
    public int maxProduct(TreeNode root) {
        totalSum += dfs(root);
        dfs(root);
        return (int)(ans%(1e9+7));
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int curSum = dfs(root.left) + dfs(root.right)+root.val;
        ans = Math.max(ans, (totalSum-curSum)*curSum);
        return curSum;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
