package leetcode.string._38;

public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = count(s);
        }
        return s;
    }

    private String count(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char c  = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == c){
                count++;
            }else{
                stringBuilder.append(count);
                stringBuilder.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(c);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }
}

