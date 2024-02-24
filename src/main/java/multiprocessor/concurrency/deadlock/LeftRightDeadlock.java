package main.java.multiprocessor.concurrency.deadlock;

/*
Пример дедлока из-за порядка блокировок
*/
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                //doSomething()
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                //doSomething();
            }
        }
    }
}
