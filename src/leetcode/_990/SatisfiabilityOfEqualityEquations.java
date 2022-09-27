package leetcode._990;

public class SatisfiabilityOfEqualityEquations {
    int[] uf = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        for (String equation : equations) {
            if(equation.charAt(1) == '='){
                uf[find(equation.charAt(0)-'a')] = find(equation.charAt(3)-'a');
            }
        }
        for (String equation : equations) {
            if(equation.charAt(1) == '!' && find(equation.charAt(0)-'a') == find(equation.charAt(3)-'a')){
                return false;
            }
        }
        return true;
    }

    private int find(int i) {
        if(i != uf[i]){
            uf[i] = find(uf[i]);
        }
        return uf[i];
    }


    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations satisfiabilityOfEqualityEquations = new SatisfiabilityOfEqualityEquations();
        System.out.println(satisfiabilityOfEqualityEquations.equationsPossible(new String[]{"a==b","b!=a"}));//Output: false
        System.out.println(satisfiabilityOfEqualityEquations.equationsPossible(new String[]{"b==a","a==b"}));//Output: true
    }
}
