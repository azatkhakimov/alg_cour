import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String result = StdIn.readString();
        int i = 2;
        while (!StdIn.isEmpty()) {

            String newWord = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / (double) i)) {
                result = newWord;
            }
            i++;
        }
        System.out.println(result);
    }
}
