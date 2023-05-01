package leetcode._2306;

import java.util.HashSet;

public class NamingaCompany {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] initialGroup = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            initialGroup[i] = new HashSet();
        }

        for (String idea : ideas) {
            initialGroup[idea.charAt(0)-'a'].add(idea.substring(1));
        }

        long ans = 0;
        for (int i = 0; i < 25; i++) {
            for (int j = i+1; j < 26; j++) {
                long numOfMutual = 0;
                for (String ideA : initialGroup[i]) {
                    if(initialGroup[j].contains(ideA)){
                        numOfMutual++;
                    }
                }
                ans += 2 * (initialGroup[i].size()-numOfMutual) * (initialGroup[j].size() - numOfMutual);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        NamingaCompany nc = new NamingaCompany();
        System.out.println(nc.distinctNames(new String[]{"coffee","donuts","time","toffee"}));//Output: 6
        System.out.println(nc.distinctNames(new String[]{"lack","back"}));//Output: 0
    }
}
