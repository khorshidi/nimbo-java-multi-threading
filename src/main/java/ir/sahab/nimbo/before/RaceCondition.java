package ir.sahab.nimbo.before;

import ir.sahab.nimbo.util.Util;

/**
 * @author Taher Khorshidi
 */
//TODO method synchronized
//TODO block synchronized
public class RaceCondition {

    public static void main(String[] args) {

        Data data = new Data();
        for (int i = 0; i < 2000; i++) {
            new Thread(new Checker(data), "T" + i).start();
        }
    }
}

class Data {

    private boolean checked = false;

    public void check() {
        if (!checked) {
            System.out.println(Thread.currentThread().getName() + " Not Checked");
            checked = true;
        } else {
            // Do work
        }
    }

}

class Checker implements Runnable {

    private Data data;

    public Checker(Data data) {
        this.data = data;
    }

    public void run() {
        Util.sleep(1000);
        data.check();
    }
}