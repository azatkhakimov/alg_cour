package leetcode._108;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return constructTree(nums, 0, nums.length-1);
    }

    private TreeNode constructTree(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, left, mid-1);
        root.right = constructTree(nums, mid+1, right);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree test = new ConvertSortedArrayToBinarySearchTree();
        System.out.println(test.sortedArrayToBST(new int[]{-10,-3,0,5,9}));//Output: [0,-3,9,-10,null,5]
        System.out.println(test.sortedArrayToBST(new int[]{1,3}));//Output: [3,1]
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
