import java.util.List;

public class Producer extends Thread {
    public List<Integer> list;

    public Producer(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        //every Producer must add 100 numbers to list
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {  //lock for other Producers
                Integer num = (int) (Math.random() * 1000);
                list.add(num);
                System.out.println("Added: " + num);
                list.notify(); //to notify waited Consumers to run
            }
            //Optional
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
