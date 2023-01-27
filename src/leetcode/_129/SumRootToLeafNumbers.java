package leetcode._129;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return 0;
    }


    public static void main(String[] args) {
        SumRootToLeafNumbers s = new SumRootToLeafNumbers();
        System.out.println(s.sumNumbers(null));
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
}
