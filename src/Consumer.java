import java.util.List;

public class Consumer extends Thread {
    public List<Integer> list;

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        //every Consumer want to read 100 numbers from list
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {  //lock for other Consumers
                while (list.size() == 0) {
                    try {
                        list.wait(); //Consumer waits for Producer to add num in list
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //read num and remove it
                Integer fetch = list.remove(0);
                System.out.println("Fetched: " + fetch);

            }
        }
    }
}
