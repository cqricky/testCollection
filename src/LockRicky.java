import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kk on 15-11-5.
 */
public class LockRicky {

    private Lock lock;

    public LockRicky(){
        lock = new ReentrantLock(true);
    }

    public void testLock(String pr) {
        lock.lock();
        System.out.println(pr);
        lock.unlock();

    }

}
