package ir.sahab.nimbo.after;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author Taher Khorshidi
 */
public class CallableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(new DateTask());
        String get = submit.get();
        System.out.println(get);
        executorService.shutdown();
    }

}

class DateTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return new Date().toString();
    }
}
    