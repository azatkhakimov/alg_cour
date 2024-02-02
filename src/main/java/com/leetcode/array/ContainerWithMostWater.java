package main.java.com.leetcode.array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int width = right - left;
            result = Math.max(result, Math.min(height[left], height[right])*width);
            if(height[left] > height[right]){
                right--;
            }else {
                left++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
