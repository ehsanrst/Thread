import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args)
            throws InterruptedException {

        //Producers produce numbers and add to this list and Consumers get from this list
        List<Integer> list = new LinkedList<>();

        //exp: We have 2 producer and 2 Consumer
        Thread[] threads = {
                new Producer(list), new Producer(list),
                new Consumer(list), new Consumer(list)
        };

        //start 4 threads
        for (Thread thread : threads) {
            thread.start();
        }

        //main thread wait until other 4 threads done
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Finished: " + list.size()); //expect 0
    }
}

