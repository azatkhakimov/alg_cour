package main.java.com.leetcode._108;

import main.java.com.leetcode.common.models.TreeNode;

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

