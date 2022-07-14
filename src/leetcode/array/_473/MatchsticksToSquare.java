package leetcode.array._473;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/matchsticks-to-square/
public class MatchsticksToSquare {
    private List<Integer> nums = new ArrayList<>();
    private int[] sums = new int[4];
    private int possSquareSide;

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length == 0) {
            return false;
        }

        int n = matchsticks.length;
        int perimeter = 0;
        for (int i = 0; i < n; i++) {
            perimeter += matchsticks[i];
        }

        possSquareSide = perimeter / 4;
        if (possSquareSide * 4 != perimeter) {
            return false;
        }

        nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(nums, Collections.reverseOrder());
        return dfs(0);
    }

    private boolean dfs(int index) {
        if (index == nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        int elem = nums.get(index);
        for (int i = 0; i < 4; i++) {
            if(sums[i]+elem <= possSquareSide){
                sums[i] += elem;
                if (dfs(index+1)){
                    return true;
                }
                sums[i] -= elem;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MatchsticksToSquare matchsticksToSquare = new MatchsticksToSquare();
        System.out.println(matchsticksToSquare.makesquare(new int[]{1, 1, 2, 2, 2}));//Output: true
        System.out.println(matchsticksToSquare.makesquare(new int[]{3, 3, 3, 3, 4}));//Output: false
    }
}
