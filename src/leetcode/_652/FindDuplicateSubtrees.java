package leetcode._652;

import leetcode.common.models.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), new HashMap<>(), res);
        return res;
    }

    private int traverse(TreeNode node, HashMap<String, Integer> tripletToId, HashMap<Integer, Integer> cnt, List<TreeNode> res) {
        if(node == null){
            return 0;
        }

        String triplet = traverse(node.left, tripletToId, cnt, res) +
                ","+node.val+
                "," + traverse(node.right, tripletToId, cnt, res);
        if(!tripletToId.containsKey(triplet)){
            tripletToId.put(triplet, tripletToId.size()+1);
        }
        int id = tripletToId.get(triplet);
        cnt.put(id, cnt.getOrDefault(id, 0)+1);
        if(cnt.get(id) == 2){
            res.add(node);
        }
        return id;
    }

    public static void main(String[] args) {

    }
}
