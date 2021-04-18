import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class CounterOfVisitorsTest {

    @Test
    void setThreshold() {
        CounterOfVisitors counterOfVisitors = new CounterOfVisitors();
        int newValueOfThreshold = 200;
        counterOfVisitors.setThreshold(newValueOfThreshold);
        assertEquals(counterOfVisitors.getThreshold(),newValueOfThreshold);
    }

    @Test
    void countVisitor() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CounterOfVisitors counterOfVisitors = new CounterOfVisitors();
        counterOfVisitors.setThreshold(101);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> counterOfVisitors.countVisitor());
        }
        Thread.sleep(100);
        executor.shutdown();
        assertEquals(counterOfVisitors.getCounter(),100);
    }


}