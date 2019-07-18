import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class CounterTetst {
    //static ReentrantLock lock = new ReentrantLock();
    static ExecutorService executorService = Executors.newFixedThreadPool(10);
    protected static   int counter = 0;

    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            Runnable run = new MyRunnable();
            executorService.submit(run);
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public synchronized void run() {
            //lock.lock();

                counter = counter + 1;
                System.out.println(counter);


            //lock.unlock();
        }
    }
}


