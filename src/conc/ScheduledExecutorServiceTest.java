package conc;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorServiceTest scheduledExecutorServiceTest = new ScheduledExecutorServiceTest();
//        scheduledExecutorServiceTest.execute();
        scheduledExecutorServiceTest.invoke();
    }

    public void execute() throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Future<String> future = executorService.schedule(() -> "Hello World", 2, TimeUnit.SECONDS);
        System.out.println(future.get());
        executorService.shutdown();
    }

    public void invoke() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(10000l);
            return "HelloWorld";
        });
        try {
            System.out.println(future.get(5, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
