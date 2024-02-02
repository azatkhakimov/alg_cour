package main.java.com.leetcode.recursive;

/*344. Reverse String
* Write a function that reverses a string.
* The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
* Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
* */
public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        solve(s, i, j);
    }

    private void solve(char[] s, int i, int j) {
        if (i > j) {
            return;
        }
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        solve(s, ++i, --j);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
