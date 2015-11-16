/**
 * Created by kk on 15-11-5.
 */
public class TestLock {

    public static void main(String[] args) {
        LockRicky ri = new LockRicky();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ri.testLock("t1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ri.testLock("t2");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                ri.testLock("t3");
            }
        });


        t1.start();
        t2.start();
        t3.start();

    }
}
