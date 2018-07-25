package ir.sahab.nimbo.before;

import ir.sahab.nimbo.util.Util;

import java.util.Date;

/**
 * @author Taher Khorshidi
 */
public class Schedule {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Util.sleep(1000);
                    System.out.println(new Date());
                }
            }
        });
        t.start();
    }
}

    