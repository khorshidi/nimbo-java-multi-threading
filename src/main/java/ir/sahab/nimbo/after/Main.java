package ir.sahab.nimbo.after;

import java.util.Date;

/**
 * @author Taher Khorshidi
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("I'm " + Thread.currentThread().getName());


        Thread workerThread = new Thread(new Worker(), "T0");
        workerThread.start();

        workerThread.join();
        System.out.println("I'm " + Thread.currentThread().getName());
    }
}

class Worker implements Runnable {

    public void run() {
        System.out.println("I'm " + Thread.currentThread().getName() + ", time is " + new Date());
    }
}
