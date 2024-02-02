package main.java.com.leetcode._187;

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        return findRepeatedDnaSequences(s, 10);
    }

    public List<String> findRepeatedDnaSequences(String s, int k){
        int windowsSize = k;
        if(s.length() <= windowsSize){
            return new ArrayList<>();
        }
        int base = 4;
        int hiPlaceValue = (int)Math.pow(base, windowsSize);
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            numbers.add(map.get(s.charAt(i)));
        }
        int hashing = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        for (int start = 0; start < s.length() - windowsSize + 1; start++) {
            if(start != 0){
                hashing = hashing * base;
                hashing -= numbers.get(start-1)*hiPlaceValue;
                hashing += numbers.get(start+windowsSize-1);
            }else {
                for (int j = 0; j < windowsSize; j++) {
                    hashing = hashing * base + numbers.get(j);
                }
            }
            if(seen.contains(hashing)){
                output.add(s.substring(start, start+windowsSize));
            }
            seen.add(hashing);
        }

        return new ArrayList<>(output);
    }

    public static void main(String[] args) {
        RepeatedDNASequences r = new RepeatedDNASequences();
        System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));//Output: ["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(r.findRepeatedDnaSequences("AAAAAAAAAAAAA"));//Output: ["AAAAAAAAAA"]
        System.out.println(r.findRepeatedDnaSequences("AGACCTAGAC", 3));
    }
}
