package leetcode._433;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);

        int steps = 0;
        while (!queue.isEmpty()){
            int nodes = queue.size();
            for (int i = 0; i < nodes; i++) {
                String node = queue.remove();
                if(node.equals(end)){
                    return steps;
                }
                for (char c : new char[]{'A', 'C', 'G', 'T'}) {
                    for (int j = 0; j < node.length(); j++) {
                        String neighbor = node.substring(0, j) + c + node.substring(j+1);
                        if(!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)){
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            steps++ ;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
        System.out.println(minimumGeneticMutation.minMutation("AACCGGTT", "AACCGGTA",
                new String[]{"AACCGGTA"}));//Output: 1
        System.out.println(minimumGeneticMutation.minMutation("AACCGGTT", "AAACGGTA",
                new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));//Output: 2
        System.out.println(minimumGeneticMutation.minMutation("AAAAACCC", "AACCCCCC", new String[]{
                "AAAACCCC", "AAACCCCC", "AACCCCCC"
        }));//Output: 3
    }
}
