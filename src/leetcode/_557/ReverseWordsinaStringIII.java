package leetcode._557;

public class ReverseWordsinaStringIII {

    public String reverseWords(String s) {
        int lastSpaceIdx = -1;
        char[] chArrays = s.toCharArray();
        int len = s.length();
        for (int strIdx = 0; strIdx <= len; strIdx++) {
            if(strIdx == len || chArrays[strIdx] == ' '){
                int startIdx = lastSpaceIdx+1;
                int endIdx = strIdx - 1;
                while (startIdx < endIdx){
                    char temp = chArrays[startIdx];
                    chArrays[startIdx] = chArrays[endIdx];
                    chArrays[endIdx] = temp;
                    startIdx++;
                    endIdx--;
                }
                lastSpaceIdx = strIdx;
            }
        }
        return new String(chArrays);
    }

    public static void main(String[] args) {
        var r = new ReverseWordsinaStringIII();
        System.out.println(r.reverseWords("Let's take LeetCode contest"));//Output: "s'teL ekat edoCteeL tsetnoc"
        System.out.println(r.reverseWords("God Ding"));//Output: "doG gniD"
    }
}
