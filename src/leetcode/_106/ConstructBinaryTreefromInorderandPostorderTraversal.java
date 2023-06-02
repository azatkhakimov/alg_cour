package leetcode._106;

import leetcode.common.models.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
     private int postIndex = 0;

     public TreeNode buildTree(int[] inorder, int[] postorder){
         int n = postorder.length;
         if (n == 0){
             return null;
         }
         if(n == 1){
             return new TreeNode(postorder[0]);
         }
         postIndex = n - 1;
         return helper(inorder, postorder, 0, n-1);

     }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex--]);
        int cur = findIndex(inorder, root.val);

        root.right = helper(inorder, postorder, cur+1, end);
        root.left = helper(inorder, postorder, start, cur-1);
        return root;
    }

    private int findIndex(int[] inorder, int key) {
        for (int i = inorder.length - 1; i >= 0; i--) {
            if(inorder[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ConstructBinaryTreefromInorderandPostorderTraversal test = new ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode treeNode = test.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
