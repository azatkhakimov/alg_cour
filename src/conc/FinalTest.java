package conc;

public class FinalTest {
    private static final FinalTest s = new FinalTest();

    public static void main(String[] args) {
        System.out.println(s);
        change(s);

    }

    private static void change(FinalTest s) {
        s = new FinalTest();
        System.out.println(s);
    }
}
