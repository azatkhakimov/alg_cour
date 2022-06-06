package leetcode.string._1461;

import java.util.HashSet;
import java.util.Set;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<>();
        for (int i = k; i <= s.length(); i++) {
            String sub = s.substring(i-k, i);
            if(!got.contains(sub)){
                got.add(sub);
                need--;
                if (need == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfaStringContainsAllBinaryCodesofSizeK test = new CheckIfaStringContainsAllBinaryCodesofSizeK();
        System.out.println(test.hasAllCodes("00110110", 2));
    }
}
