package leetcode._42;

public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right){
            if(height[left] > leftMax){
                leftMax = height[left];
            }
            if(height[right] > rightMax){
                rightMax = height[right];
            }
            if(leftMax < rightMax){
                ans += Math.max(0, leftMax-height[left]);
                left++;
            }else {
                ans += Math.max(0, rightMax-height[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));//Output: 6
        System.out.println(trappingRainWater.trap(new int[]{4,2,0,3,2,5}));//Output: 9
    }
}
