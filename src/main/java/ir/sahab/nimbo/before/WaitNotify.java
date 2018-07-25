package ir.sahab.nimbo.before;

import ir.sahab.nimbo.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Taher Khorshidi
 */
//TODO wait/notify without monitor
//TODO wait/notify with monitor
public class WaitNotify {

    public static void main(String[] args) {

        Util.sleep(10000);
        ArrayList<Long> queue = new ArrayList<Long>();
        Thread producer = new Thread(new Producer(queue), "Producer");
        Thread consumer = new Thread(new Consumer(queue), "Consumer");

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
        Util.sleep(1000);
        for (int i = 0; i < 20; i++) {
            Util.sleep(500);
            Long t = System.currentTimeMillis();
            queue.add(t);
            System.out.println(i + " produce " + t);
        }
    }
}

class Consumer implements Runnable {

    private final List<Long> queue;

    public Consumer(List<Long> queue) {
        this.queue = queue;
    }

    public void run() {
        Util.sleep(1000);
        for (int i = 0; i < 20; i++) {
            if (!queue.isEmpty()) {
                Long aLong = queue.get(0);
                System.out.println("consume " + aLong);
            } else {
                System.out.println("QUEUE IS EMPTY!");
            }
        }
    }
}
