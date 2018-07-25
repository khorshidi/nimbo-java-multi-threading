package ir.sahab.nimbo.before;

/**
 * @author Taher Khorshidi
 */
//TODO thread by extend Thread
//TODO thread by implement Runnable
//TODO thread by anonymous
//TODO thread set name
//TODO join
public class Main {

    public static void main(String[] args) {
        System.out.println("I'm " + Thread.currentThread().getName());
    }
}

//class Worker implements Runnable {
//
//    public void run() {
//        System.out.println("I'm " + Thread.currentThread().getName() + ", time is " + new Date());
//    }
//}
