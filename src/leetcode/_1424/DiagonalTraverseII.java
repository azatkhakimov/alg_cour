package leetcode._1424;

import java.util.*;

public class DiagonalTraverseII {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int row = p[0];
            int col = p[1];
            ans.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new int[]{row + 1, col});
            }
            if (col + 1 < nums.get(row).size()) {
                queue.offer(new int[]{row, col + 1});
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        var d = new DiagonalTraverseII();
        System.out.println(Arrays.toString(d.findDiagonalOrder(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)))));//1,4,2,7,5,3,8,6,9]
        System.out.println(Arrays.toString(d.findDiagonalOrder(List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7), List.of(8),
                List.of(9, 10, 11), List.of(12, 13, 14, 15, 16)))));//Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
    }
}


