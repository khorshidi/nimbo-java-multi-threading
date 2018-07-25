package ir.sahab.nimbo.before;

import ir.sahab.nimbo.util.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Taher Khorshidi
 */
public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task(i));
        }
    }
}

class Task implements Runnable {

    int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Util.sleep(1000);
        System.out.println("I'm " + id + " (" + Thread.currentThread().getName() + ")");
    }
}

    