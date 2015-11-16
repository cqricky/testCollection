import java.util.concurrent.locks.LockSupport;

/**
 * Created by kk on 15-11-7.
 */
public class ThreadTest {

    public static void main(String [] args) {
//        try {
//            testA();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            testB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testA() throws Exception{
        Thread ta = new ThreadA("TA");
        ta.start();


        System.out.println("before interrupt: " + ta.isInterrupted());

//        Thread.sleep(10);
        System.out.println(ta.getState() + " start thread interrupt");
        ta.interrupt();
        System.out.println(ta.getState() + " thread interrupted");
        //ta.notify();

        System.out.println("after interrupt: " + Thread.interrupted());
        System.out.println("after interrupt: " + ta.isInterrupted());


    }


    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public synchronized void run() {
            try {
                System.out.println("start");
                int i = 100000;
                while (i > 0) {
                    //System.out.println("test: " + i);
                    if(i == 3000) {

                       // wait();
                    }


                    i--;
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(this.getName() +  " after interrupt: " + ThreadA.interrupted());
                System.out.println(this.getName() +  " after interrupt: " + this.isInterrupted());
                System.out.println("end");
            }
        }
    }


    public static void testB() throws Exception{
        Thread tb = new ThreadB("TB");
        System.out.println("before interrupt: " + tb.isInterrupted());

        tb.start();


        Thread.sleep(100);
        System.out.println(tb.getState() + " start thread interrupt");
        tb.interrupt();
        System.out.println(tb.getState() + " thread interrupted");

//        System.out.println(tb.getState() + " start thread unpark");
//        LockSupport.unpark(tb);
//        System.out.println(tb.getState() + " start thread unpark");

        Thread.sleep(100);
        System.out.println("after interrupt: " + tb.isInterrupted());


    }



    static class ThreadB extends Thread {

        public ThreadB(String name) {
            super(name);
        }


        @Override
        public void run() {
            System.out.println("start");

            int i = 100000;
            while (i > 0) {
                //System.out.println("test: " + i);
                if(i == 9000) {
                    System.out.println(this.getName() + " " + this.getState() + " start park.");
                    LockSupport.park(this);
                    System.out.println(this.getName() + " " + this.getState() + " end park");




                }
                i--;
            }
            System.out.println(this.getName() + " " + this.getState() + " thread interrupted: " + Thread.interrupted());
            System.out.println(this.getName() + " " + this.getState() + " thread interrupted: " + this.isInterrupted());

            System.out.println("end");
        }
    }

}
