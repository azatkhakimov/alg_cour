package main.java.multiprocessor.holder;

public class Holder {
    private final int n;

    public Holder(int n) {
        this.n = n;
    }
    public void assertSanity(){
        if(n != n){
            throw new AssertionError();
        }
    }
}
