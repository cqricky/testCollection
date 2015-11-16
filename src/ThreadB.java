import java.util.concurrent.locks.LockSupport;

/**
 * Created by caiqing on 15/11/10.
 */
public class ThreadB extends Thread{
    public ThreadB(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(this.getName() + " " + this.getState() + " interrupte1: " + this.isInterrupted());
            synchronized (this) {
                int i = 10000;
                System.out.println(this.getName() + " " + this.getState() + " interrupte2: " + this.isInterrupted());
                while (i > 0) {

                    if(i == 9000) {
                        System.out.println(this.getName() + " " + this.getState() + " wait");
                        notify();
                        wait();

                    }
                    i--;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this.getName() + " " + this.getState() + " interrupte3: " + this.isInterrupted());
            System.out.println(this.getName() + " " + this.getState() + " interrupte4: " + this.isInterrupted());
            e.printStackTrace();
        } finally {

        }

    }

}
