package leetcode.array._448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!numbers.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray test = new FindAllNumbersDisappearedInAnArray();
        System.out.println(test.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));//Output: [5,6];
        System.out.println(test.findDisappearedNumbers(new int[]{1,1}));//Output: [2];
    }
}
