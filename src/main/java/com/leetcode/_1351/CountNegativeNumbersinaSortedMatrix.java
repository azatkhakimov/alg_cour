package main.java.com.leetcode._1351;

public class CountNegativeNumbersinaSortedMatrix {

    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        for (int[] arr : grid) {
            int left = 0;
            int right = arr.length-1;
            while (left <= right){
                int mid = left+(right-left)/2;
                if(arr[mid] >= 0){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
            count += (n-left);
        }
        return count;
    }


    public static void main(String[] args) {
       var c = new CountNegativeNumbersinaSortedMatrix();
        System.out.println(c.countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));//Output: 8
        System.out.println(c.countNegatives(new int[][]{{3,2},{1,0}}));//Output: 0
    }
}
