package leetcode._953;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i)-'a'] = i;
        }

        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if(j >= words[i+1].length()){
                    return false;
                }

                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    int curWordChar = words[i].charAt(j)-'a';
                    int nextWordChar = words[i+1].charAt(j)-'a';
                    if(orderMap[curWordChar] > orderMap[nextWordChar]){
                        return false;
                    }else {
                        break;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary dictionary = new VerifyingAnAlienDictionary();
        System.out.println(dictionary.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));//Output: true
        System.out.println(dictionary.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));//Output: false
        System.out.println(dictionary.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));//Output: false
    }
}
