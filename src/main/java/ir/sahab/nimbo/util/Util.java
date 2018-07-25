package ir.sahab.nimbo.util;

/**
 * @author Taher Khorshidi
 */
public class Util {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
