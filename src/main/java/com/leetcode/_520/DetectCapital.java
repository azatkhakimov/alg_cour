package main.java.com.leetcode._520;

//https://www.youtube.com/watch?v=i8C2x_HvomM
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.toCharArray().length; i++) {
            if(Character.isUpperCase(word.charAt(i))){
                count++;
            }
        }
        return count == 0 || count == word.length() || (count == 1 && Character.isUpperCase(word.charAt(0)));
    }

    public static void main(String[] args) {
        DetectCapital capital = new DetectCapital();
        System.out.println(capital.detectCapitalUse("USA"));//Output: true
        System.out.println(capital.detectCapitalUse("FlaG"));//Output: false
    }
}
