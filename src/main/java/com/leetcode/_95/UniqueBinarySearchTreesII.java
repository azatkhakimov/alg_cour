package main.java.com.leetcode._95;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        List<List<List<TreeNode>>> dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            List<List<TreeNode>> innerList = new ArrayList<>(n+1);
            for (int j = 0; j <= n; j++) {
                innerList.add(new ArrayList<>());
            }
            dp.add(innerList);
        }

        for (int i = 0; i <= n; i++) {
            dp.get(i).get(i).add(new TreeNode(i));
        }

        for (int numberOfNodes = 2; numberOfNodes <= n; numberOfNodes++) {
            for (int start = 1; start <= n-numberOfNodes+1; start++) {
                int end = start+numberOfNodes-1;
                for (int i = start; i <= end; i++) {
                    List<TreeNode> leftSubTrees = (i != start) ? dp.get(start).get(i-1) : new ArrayList<>();
                    if(leftSubTrees.isEmpty()){
                        leftSubTrees.add(null);
                    }
                    List<TreeNode> rightSubTrees = (i != end) ? dp.get(i+1).get(end) : new ArrayList<>();
                    if(rightSubTrees.isEmpty()){
                        rightSubTrees.add(null);
                    }
                    for (TreeNode left : leftSubTrees) {
                        for (TreeNode right : rightSubTrees) {
                            TreeNode root = new TreeNode(i, left, right);
                            dp.get(start).get(end).add(root);
                        }
                    }
                }
            }
        }
        return dp.get(1).get(n);
    }


    public static void main(String[] args) {
        var u = new UniqueBinarySearchTreesII();
        System.out.println(u.generateTrees(3));//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
        System.out.println(u.generateTrees(1));//Output: [[1]]
    }
}
