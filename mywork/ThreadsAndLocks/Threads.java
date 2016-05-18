/*
    Basics
*/

class MyTask1 extends Thread {
    //...

    public void run() {
        try{
            // do the work
        } catch (InterruptedException e) {

        }
    }
    //...
}

class MyTask2 implements Runnable {
    // ...

    public void run() {
        try{
            // do the work
        } catch (InterruptedException e) {

        }
    }

    // ...
}


class MyClass {

    public syncronized void doSomething() {
        // use the resource
    }

    public void doSomething2() {
        syncronized(this) {
            // use the resource
        }
    }

}
