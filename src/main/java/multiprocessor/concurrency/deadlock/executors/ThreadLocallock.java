package main.java.multiprocessor.concurrency.deadlock.executors;

import java.util.concurrent.*;

//Link to the reason of deadlock
// https://stackoverflow.com/questions/14661036/is-thread-starvation-deadlock-happening-here-in-the-code
public class ThreadLocallock {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadLocallock threadLocallock = new ThreadLocallock();
        ThreadLocallock.RenderPage renderPage = threadLocallock.new RenderPage();
        Future<String> result = threadLocallock.exec.submit(renderPage);
        System.out.println(result.get());
    }

    public class RenderPage implements Callable<String> {

        @Override
        public String call() throws Exception {

            Future<String> head = exec.submit(() -> "1");
            Future<String> foot = exec.submit(() -> "2");
            System.out.println("Отработал");
            return head.get() + " " + foot.get();
        }
    }


}


