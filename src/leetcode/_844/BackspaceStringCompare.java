package leetcode._844;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int pointerS = s.length() - 1;
        int pointerT = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (pointerS >= 0 || pointerT >= 0) {
            while (pointerS >= 0) {
                if (s.charAt(pointerS) == '#') {
                    skipS += 1;
                    pointerS -= 1;
                } else if (skipS > 0) {
                    pointerS -= 1;
                    skipS -= 1;

                } else {
                    break;
                }
            }

            while (pointerT >= 0) {
                if (t.charAt(pointerT) == '#') {
                    skipT += 1;
                    pointerT -= 1;
                } else if (skipT > 0) {
                    pointerT -= 1;
                    skipT -= 1;
                } else {
                    break;
                }
            }

            if(pointerS >= 0 && pointerT >=0 && s.charAt(pointerS) != t.charAt(pointerT)){
                return false;
            }

            if((pointerS>=0) != (pointerT >=0)){
                return false;
            }

            pointerS-=1;
            pointerT-=1;
        }
        return true;

    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare("ab#c", "ad#c"));//Output: true
        System.out.println(backspaceStringCompare.backspaceCompare("ab##", "c#d#"));//Output: true
        System.out.println(backspaceStringCompare.backspaceCompare("a#c", "b"));//Output: false
    }
}
