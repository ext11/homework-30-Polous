import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterOfVisitors {
    private int counter;
    private  int threshold ;


    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public synchronized void countVisitor() {
        counter++;
        if (counter > threshold - 1) {
            counter = 0;
        }

    }

    public int getCounter() {
        return counter;
    }



    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CounterOfVisitors counterOfVisitors = new CounterOfVisitors();
        counterOfVisitors.setThreshold(101);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> counterOfVisitors.countVisitor());
        }
        Thread.sleep(100);
        executor.shutdown();
        System.out.println(counterOfVisitors.getCounter());
    }

    public int getThreshold() {
        return threshold;
    }
}
