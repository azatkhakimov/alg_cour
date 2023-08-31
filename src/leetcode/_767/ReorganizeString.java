package leetcode._767;

public class ReorganizeString {


    public String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c-'a']++;
        }
        int maxCount = 0;
        int letter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if(charCounts[i] > maxCount){
                maxCount = charCounts[i];
                letter  = i;
            }
        }
        if(maxCount > (s.length() +1)/2){
            return "";
        }

        char[] ans = new char[s.length()];
        int index = 0;
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0){
                if(index >= s.length()){
                    index = 1;
                }

                ans[index] = (char)(i+'a');
                index += 2;
                charCounts[i]--;
            }
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        var r = new ReorganizeString();
        System.out.println(r.reorganizeString("aab"));//Output: "aba"
        System.out.println(r.reorganizeString("aaab"));//Output: ""
    }
}
