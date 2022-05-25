package leetcode.tree._297;

import leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        buildString(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void buildString(TreeNode root, StringBuilder stringBuilder) {
        if(root == null){
            stringBuilder.append(NN).append(spliter);
        }else {
            stringBuilder.append(root.val).append(spliter);
            buildString(root.left, stringBuilder);
            buildString(root.right, stringBuilder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String node = nodes.remove();
        if(NN.equals(node)){
            return null;
        }else {
            TreeNode root = new TreeNode(Integer.parseInt(node));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}
