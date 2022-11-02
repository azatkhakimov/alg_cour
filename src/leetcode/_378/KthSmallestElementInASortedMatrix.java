package leetcode._378;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1] + 1;
        while (low < high){
            int mid = low+(high-low)/2;
            int count = 0;
            int j = matrix[0].length-1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += (j+1);
            }
            if(count < k){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        System.out.println(test.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));//Output: 13
        System.out.println(test.kthSmallest(new int[][]{{-5}},  1));//Output: -5
    }

}
