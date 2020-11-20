package multithreading;

public class ThreeTypeRunThreads {

    public static void main(String[] args) {
        Thread t1 = new HelloThread("HelloThread");
        Thread t2 = new Thread(new HelloRunable(),"runnable-thread");
        Thread t3 = new Thread(() ->{
            System.out.printf("Hello I`m %s\n", Thread.currentThread().getName());
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

class HelloThread extends Thread{
    public HelloThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.printf("Hello I`m %s\n",getName());
    }
}

class HelloRunable implements Runnable{
    @Override
    public void run() {
        System.out.printf("Hello I`m %s\n", Thread.currentThread().getName());
    }
}
