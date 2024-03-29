package main.java.com.leetcode.array._744;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters.length == left ? letters[0] : letters[left];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget target = new FindSmallestLetterGreaterThanTarget();
        System.out.println(target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));//Output: "c"
        System.out.println(target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));//Output: "f"
    }
}
