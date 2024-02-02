package main.java.com.leetcode._894;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0){
            return new ArrayList<>();
        }
        List<List<TreeNode>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(1).add(new TreeNode(0));
        for (int count = 3; count <= n; count+=2) {
            for (int i = 1; i < count - 1; i+=2) {
                int j = count-1-i;
                for (TreeNode left : dp.get(i)) {
                    for (TreeNode right : dp.get(j)) {
                        TreeNode root = new TreeNode(0, left, right);
                        dp.get(count).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        var a = new AllPossibleFullBinaryTrees();
        System.out.println(a.allPossibleFBT(7));//Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
        System.out.println(a.allPossibleFBT(3));//Output: [[0,0,0]]
    }
}
