/*
    Famous Dinning Philosophors problem. Each can eat only if they have 2 spoons
*/

class Spoon {
    private Lock lock;
    public Spoon() {
        lock = new RentrantLock()
    }
    public boolean pickup() {
        return lock.tryLock();
    }

    public void keepDown() {
        lock.unlock();
    }
}

class Philosophor extends Thread {
    private Spoon left;
    private Spoon right;
    public Philosophor() {
        left = new Spoon();
        right = new Spoon();
    }

    private boolean pickup() {
        if(!left.pickup()) {
            return false;
        }
        if(!right.pickup()) {
            left.keepDown(); // IF YOU COMMENT THIS LINE then DEADLOCK can occur
            return false;
        }

        return true;
    }

    private void keepDown() {
        left.keepDown();
        right.keepDown();
    }

    private void chew() {
        // Do eating ....
    }

    public void eat() {
        if(pickup()) {
            chew();
            keepDown();
        }
    }

    public void run() {
        // .... catch InterruptedException
    }
}
