package leetcode._658;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-k;
        while (left < right){
            int mid = left+(right-left)/2;
            if(x - arr[mid] > arr[mid+k]-x){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return Arrays.stream(arr, left, left+k).boxed().collect(Collectors.toList());
    }
    public static void main(String[] args) {
        FindKClosestElements elements = new FindKClosestElements();
        System.out.println(elements.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));//Output: [1,2,3,4]
        System.out.println(elements.findClosestElements(new int[]{1,2,3,4,5}, 4, 1));//Output: [1,2,3,4]
    }
}
