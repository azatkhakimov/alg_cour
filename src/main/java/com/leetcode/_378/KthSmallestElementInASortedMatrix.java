package main.java.com.leetcode._378;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int rowCount = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for (int i = 0; i < rowCount; i++) {
            System.out.println("idx "+i +" el: "+matrix[i][0]);
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        int numbersChecked = 0;
        int smallestElement = 0;
        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            smallestElement = curr[0];
            int rowIdx = curr[1];
            int colIdx = curr[2];
            numbersChecked++;
            if(numbersChecked == k){
                break;
            }

            if(colIdx+1 < matrix[rowIdx].length){
                minHeap.offer(new int[]{matrix[rowIdx][colIdx+1], rowIdx, colIdx+1});
            }
        }
        return smallestElement;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        System.out.println(test.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));//Output: 13
       // System.out.println(test.kthSmallest(new int[][]{{-5}},  1));//Output: -5
    }

}
