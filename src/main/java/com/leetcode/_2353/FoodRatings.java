package main.java.com.leetcode._2353;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {
    private Map<String, Integer> foodRatingMap;
    private Map<String, String> foodCuisineMap;
    private Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i],
                    k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }

    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        String cuisineName = foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisineName).add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        Food highestRated = cuisineFoodMap.get(cuisine).peek();
        while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
            cuisineFoodMap.get(cuisine).poll();
            highestRated = cuisineFoodMap.get(cuisine).peek();
        }
        return highestRated.foodName;
    }

    class Food implements Comparable<Food> {
        public int foodRating;
        public String foodName;

        public Food(int foodRating, String foodName) {
            this.foodRating = foodRating;
            this.foodName = foodName;
        }

        @Override
        public int compareTo(Food o) {
            if (foodRating == o.foodRating) {
                return foodName.compareTo(o.foodName);
            }
            return -1 * Integer.compare(foodRating, o.foodRating);
        }
    }
}
