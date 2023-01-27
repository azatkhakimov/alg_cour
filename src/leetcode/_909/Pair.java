package leetcode._909;

public class Pair<T, R> {
    private T val1;
    private R val2;

    public Pair(T val1, R val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public T getKey() {
        return val1;
    }

    public R getValue() {
        return val2;
    }
}
