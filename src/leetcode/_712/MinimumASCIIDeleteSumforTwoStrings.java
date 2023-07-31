package leetcode._712;

public class MinimumASCIIDeleteSumforTwoStrings {


    public int minimumDeleteSum(String s1, String s2) {
        if(s1.length() < s2.length()){
            return minimumDeleteSum(s2, s1);
        }
        int m = s1.length();
        int n = s2.length();
        int[] currRow = new int[n+1];
        for (int j = 1; j <= n; j++) {
            currRow[j] = currRow[j-1] + s2.charAt(j-1);
        }

        for (int i = 1; i <= m; i++) {
            int diag = currRow[0];
            currRow[0] += s1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                int answer;

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    answer = diag;
                }else {
                    answer = Math.min(
                            s1.charAt(i-1)+currRow[j],
                            s2.charAt(j-1)+currRow[j-1]);
                }
                diag = currRow[j];
                currRow[j] = answer;

            }
        }
        return currRow[n];
    }



    public static void main(String[] args) {
        var m = new MinimumASCIIDeleteSumforTwoStrings();
        System.out.println(m.minimumDeleteSum("sea", "eat"));//Output: 231
        System.out.println(m.minimumDeleteSum("delete", "leet"));//Output: 403
    }
}
