
class OddNumberGenerator implements Runnable {
    private Object lock = null;
    private number = 1;
    public OddNumberGenerator(Object lockObj) {
        lock = lockObj;
    }
    public void run() {
        while(number < 100) {
            syncronized(lock) {
                system.out.println("  " + number);
                number += 2;
                lock.notify();
                lock.wait();
            }
        }
    }
}

class EvenNumberGenerator implements Runnable {
    private Object lock = null;
    private number;
    public OddNumberGenerator(Object lockObj) {
        lock = lockObj;
        number = 2;
    }
    public void run() {
        while(number < 100) {
            syncronized(lock) {
                lock.wait(); // can throw InterruptedException
                system.out.println("  " + number);
                number += 2;
                lock.notify();
            }
        }
    }
}

Object syncObject = new Object();
Thread oddThread = new Thread(new OddNumberGenerator(syncObject));
Thread evenThread = new Thread(new EvenNumberGenerator(syncObject));
oddThread.start();
evenThread.start();
oddThread.join();
evenThread.join();
