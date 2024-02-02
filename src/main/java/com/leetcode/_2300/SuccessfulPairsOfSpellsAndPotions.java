package main.java.com.leetcode._2300;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int m = potions.length;
        int maxPotion = potions[m - 1];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long minPotion = (long) Math.ceil((1.0 * success) / spell);
            if (minPotion > maxPotion) {
                ans[i] = 0;
                continue;
            }
            int index = lowerBound(potions, (int) minPotion);
            ans[i] = m - index;
        }
        return ans;
    }

    private int lowerBound(int[] potions, int minPotion) {
        int lo = 0;
        int hi = potions.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (potions[mid] < minPotion) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        SuccessfulPairsOfSpellsAndPotions s = new SuccessfulPairsOfSpellsAndPotions();
        System.out.println(Arrays.toString(s.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));//Output: [4,0,3]
        System.out.println(Arrays.toString(s.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));//Output: [2,0,2]
    }

}
