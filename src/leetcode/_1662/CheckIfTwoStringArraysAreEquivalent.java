package leetcode._1662;

public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String word : word1){
            sb1.append(word);
        }
        for(String word : word2){
            sb2.append(word);
        }
        String wor1 = sb1.toString();
        String wor2  = sb2.toString();
        if(wor1.length() != wor2.length()){
            return false;
        }
        int n = wor1.length();
        for(int i = 0; i < n; i++){
            if(wor1.charAt(i) != wor2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var c = new CheckIfTwoStringArraysAreEquivalent();
        System.out.println(c.arrayStringsAreEqual(new String[]{"ab", "c"},
                new String[]{"a", "bc"}));//Output: true
        System.out.println(c.arrayStringsAreEqual(new String[]{"a", "cb"},
                new String[]{"ab", "c"}));//Output: false
        System.out.println(c.arrayStringsAreEqual(new String[]{"abc", "d", "defg"},
                new String[]{"abcddefg"}));//Output: true
    }
}
