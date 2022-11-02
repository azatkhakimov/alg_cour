package leetcode._1832;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c: sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;
    }
    public static void main(String[] args) {
        CheckIfTheSentenceIsPangram pangrammer = new CheckIfTheSentenceIsPangram();
        System.out.println(pangrammer.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));//Output: true
        System.out.println(pangrammer.checkIfPangram("leetcode"));//Output: false
    }
}
