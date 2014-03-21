package threads;

/**
 * Author: Daniel
 */


public class ThreadsDemo {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("Naciścnij Ctrl + C, aby zakonczyć...");
    }
}

class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        if (!valueSet)
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Złapano InterruptedException");
            }

        System.out.println("Pobrano: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        if (valueSet)
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Złapano InterruptedException");
            }

        this.n = n;
        valueSet = true;
        System.out.println("Włożono: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producent").start();
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Konsumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}
