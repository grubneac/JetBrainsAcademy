package multithreading;

public class InterruptionDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread counter = new Thread(new CountingTask());
        counter.start();
        Thread.sleep(5000L);
        counter.interrupt();
        counter.join();
    }
}
class CountingTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Start counting");
        int i = 1; // the first number to print

        try {
            while (!Thread.interrupted()) {
                System.out.println(i);
                i++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Sleeping was interrupted");
        }
        System.out.println("Finishing");
    }
}