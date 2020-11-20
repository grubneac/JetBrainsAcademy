package multithreading;

public class MainThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("name: " + t.getName());
        System.out.println("priority: " + t.getPriority());
        System.out.println("getId: " + t.getId());
        System.out.println("isAlive: " + t.isAlive());
        System.out.println("isDaemon: " + t.isDaemon());

        t.setName("my-thread");
        System.out.println("New name: " + t.getName());
        System.out.println(Thread.MIN_PRIORITY + " " + Thread.MAX_PRIORITY);

    }
}
