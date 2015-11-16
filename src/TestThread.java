
/**
 * Created by caiqing on 15/11/10.
 */
public class TestThread {
    public static void main(String [] args) {

        testSync();


    }

    public static void testSync() {
        ThreadB tb = new ThreadB("tb");

        synchronized (tb) {
            System.out.println("start");
            tb.start();



            try {
                Thread.sleep(1000);
                System.out.println("main wait");
                tb.wait();
                System.out.println("after main wait");
                System.out.println("sleep");
                Thread.sleep(2000);

                System.out.println("start interrupt");
                tb.interrupt();
                System.out.println("tb interruppt: " + tb.isInterrupted());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }

    public static void testLock() {
        ThreadA ta = new ThreadA("ta");
        ta.start();

        try {
            Thread.sleep(1000);
            System.out.println("Start interrupt!!!");

//            LockSupport.unpark(ta);
            ta.interrupt();
            System.out.println("after interrupt: " + ta.isInterrupted());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
