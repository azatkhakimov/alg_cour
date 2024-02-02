package main.java.com.leetcode._74;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows*cols-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if(matrix[mid/cols][mid%cols] == target){
                return true;
            } else if (matrix[mid/cols][mid%cols] < target) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix matrix = new SearchA2DMatrix();
        System.out.println(matrix.searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                },
                3
        ));//Output: true
        System.out.println(matrix.searchMatrix(
                new int[][]{
                        {1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,60}
                },
                13
        ));//Output: false

        System.out.println(matrix.searchMatrix(
                new int[][]{
                        {1,3}
                },
                3
        ));//Expected true
    }
}
