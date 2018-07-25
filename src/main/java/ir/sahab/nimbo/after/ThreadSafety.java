package ir.sahab.nimbo.after;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Taher Khorshidi
 */
public class ThreadSafety {

    public static void main(String[] args) throws InterruptedException {

        UnsafeMap map = new UnsafeMap();
        map.init("test", 0);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    map.increase("test");
                }
            }));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(map);


    }
}

class UnsafeMap {

    private final HashMap<String, Integer> internal = new HashMap<>();

    public void init(String key, Integer value) {
        internal.put(key, value);
    }

    public void increase(String key) {
        synchronized (internal) {
            int a = internal.get(key);
            internal.put(key, a + 1);
        }
    }

    @Override
    public String toString() {
        return internal.toString();
    }

}