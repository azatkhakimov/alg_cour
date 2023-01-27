package leetcode._904;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=za2YuucS0tw
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        if(fruits == null || fruits.length == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < fruits.length){
            if(map.size() <= 2){
                map.put(fruits[j], j++);
            }
            if(map.size() > 2){
                int min = fruits.length-1;
                for (Integer value : map.values()) {
                    min = Math.min(min, value);
                }
                i = min + 1;
                map.remove(fruits[min]);
            }
            max = Math.max(max, j-i);
        }
        return max;
    }

    public static void main(String[] args) {
        FruitIntoBaskets baskets = new FruitIntoBaskets();
        System.out.println(baskets.totalFruit(new int[]{1,2,1}));//Output: 3
        System.out.println(baskets.totalFruit(new int[]{0,1,2,2}));//Output: 3
        System.out.println(baskets.totalFruit(new int[]{1,2,3,2,2}));//Output: 4
    }
}
