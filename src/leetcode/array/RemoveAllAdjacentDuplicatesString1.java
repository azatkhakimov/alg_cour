package leetcode.array;

public class RemoveAllAdjacentDuplicatesString1 {
    public String removeDuplicates(String s) {
        char[] stack = new char[s.length()];
        int counter = 0;

        for (int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);

            if(counter >0 && stack[counter-1] == currentChar){
                counter--;
            }else {
                stack[counter] = currentChar;
                counter+=1;
            }
        }
        return new String(stack, 0, counter);
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesString1 test = new RemoveAllAdjacentDuplicatesString1();
        System.out.println(test.removeDuplicates("abbaca"));
    }
}
