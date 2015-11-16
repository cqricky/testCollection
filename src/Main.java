import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", "test");
    }

    public void test() {
        Lock lock = new ReentrantLock();

        Map<String, String> maptest = new HashMap<String, String>();

        maptest.put("test", "test");


        CountDownLatch doneSignal = new CountDownLatch(5);

        ReadWriteLock lock1 = new ReentrantReadWriteLock();
    }
}
