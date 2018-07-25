package ir.sahab.nimbo.after;

import ir.sahab.nimbo.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Taher Khorshidi
 */
public class WaitNotify {

    public static void main(String[] args) {

        ArrayList<Long> queue = new ArrayList<Long>();
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();

    }
}

class Producer implements Runnable {

    private final List<Long> queue;

    public Producer(List<Long> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            Util.sleep(500);
            Long t = System.currentTimeMillis();
            queue.add(t);
            System.out.println("produce " + t);
            synchronized (queue) {
                queue.notify();
            }
        }
    }
}

class Consumer implements Runnable {

    private final List<Long> queue;

    public Consumer(List<Long> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (queue) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!queue.isEmpty()) {
                Long aLong = queue.get(0);
                System.out.println("consume " + aLong);
            } else {
                System.out.println("QUEUE IS EMPTY!");
            }
        }
    }
}
