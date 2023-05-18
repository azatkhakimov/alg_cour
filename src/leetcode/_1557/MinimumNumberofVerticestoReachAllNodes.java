package leetcode._1557;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberofVerticestoReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] incomingEdgeExist = new boolean[n];
        for (List<Integer> edge : edges) {
            incomingEdgeExist[edge.get(1)] = true;
        }
        List<Integer> required = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!incomingEdgeExist[i]){
                required.add(i);
            }
        }
        return required;
    }

    public static void main(String[] args) {
        var m = new MinimumNumberofVerticestoReachAllNodes();
        System.out.println(m.findSmallestSetOfVertices(
                6,
                List.of(List.of(0,1), List.of(0,2), List.of(2,5), List.of(3,4), List.of(4,2))
        ));//Output: [0,3]
        System.out.println(m.findSmallestSetOfVertices(
                5,
                List.of(List.of(0,1), List.of(2,1), List.of(3,1), List.of(1,4), List.of(2,4)
        )));//Output: [0,2,3]
    }
}
