package leetcode._1125;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SmallestSufficientTeam {
    int n;
    int[] skillsMaskOfPerson;
    long[] dp;


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        n = people.size();
        int m = req_skills.length;
        HashMap<String, Integer> skillId = new HashMap<>();
        for (int i = 0; i < m; i++) {
            skillId.put(req_skills[i], i);
        }

        skillsMaskOfPerson = new int[n];
        for (int i = 0; i < n; i++) {
            for (String skill : people.get(i)) {
                skillsMaskOfPerson[i] |= 1 << skillId.get(skill);
            }
        }
        dp = new long[1 << m];
        Arrays.fill(dp, -1);
        long answerMask = f((1 << m) - 1);
        int[] ans = new int[Long.bitCount(answerMask)];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (((answerMask >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }

    private long f(int skillMask) {
        if (skillMask == 0) {
            return 0L;
        }
        if (dp[skillMask] != -1) {
            return dp[skillMask];
        }

        for (int i = 0; i < n; i++) {
            int smallerSkillsMask = skillMask & ~skillsMaskOfPerson[i];
            if (smallerSkillsMask != skillMask) {
                long peopleMask = f(smallerSkillsMask) | (1L << i);
                if (dp[skillMask] == -1 || Long.bitCount(peopleMask) < Long.bitCount(dp[skillMask])) {
                    dp[skillMask] = peopleMask;
                }
            }
        }
        return dp[skillMask];
    }

    public static void main(String[] args) {
        var s = new SmallestSufficientTeam();
        System.out.println(Arrays.toString(s.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},
                List.of(List.of("java"), List.of("nodejs"), List.of("nodejs", "reactjs")))));//Output: [0,2]
        System.out.println(Arrays.toString(s.smallestSufficientTeam(new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"},
                List.of(List.of("algorithms", "math", "java"), List.of("algorithms", "math", "reactjs"), List.of("java", "csharp", "aws"), List.of("reactjs", "csharp"), List.of("csharp", "math"),
                        List.of("aws", "java")))));//Output: [1,2]

    }
}
