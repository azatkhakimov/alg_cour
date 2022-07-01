package leetcode.array._1710;

import java.util.Arrays;
/*
* https://leetcode.com/problems/maximum-units-on-a-truck/*/
public class MaximumUnitsOnaTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> Integer.compare(b[1], a[1]));
        int boxes = 0;
        for (int[] boxType : boxTypes) {
            if(truckSize >= boxType[0]){
                boxes += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            }else {
                boxes += truckSize * boxType[1];
                return boxes;
            }
        }
        return boxes;
    }
    public static void main(String[] args) {
        MaximumUnitsOnaTruck maximumUnitsOnaTruck = new MaximumUnitsOnaTruck();
        System.out.println(maximumUnitsOnaTruck.maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4));//Output: 8
        System.out.println(maximumUnitsOnaTruck.maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}},  10));//Output: 91
    }
}
