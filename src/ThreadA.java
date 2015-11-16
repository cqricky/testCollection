import java.util.concurrent.locks.LockSupport;

/**
 * Created by caiqing on 15/11/10.
 */
public class ThreadA extends Thread{
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {


            Thread.sleep(100);

            System.out.println(this.getName() + " " + this.getState() + " interrupte: " + this.isInterrupted());
            System.out.println("park");
            LockSupport.park(this);

            System.out.println("uppark");
            System.out.println(this.getName() + " " + this.getState() + " interrupte: " + this.isInterrupted());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }

    }

}
