package leetcode._2353;

public class DesignaFoodRatingSystem {


    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings.highestRated("korean")); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese")); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
        // Both "sushi" and "ramen" have a rating
    }
}
