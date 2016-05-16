package com.harsha.demo;

import java.util.ArrayList;

class Producer extends Thread {
	private int counter = 0;
	private ArrayList<Integer> array = null;

	public Producer(ArrayList<Integer> arr) {
		super();
		array = arr;
	}

	public void run() {

		while (true) {
			try {
				produce();
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void produce() throws InterruptedException {
		synchronized (array) {
			while (array.size() == 2) {
				try {
					array.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			array.add(++counter);
			System.out.println("producer: " + counter);

			array.notify();
		}
	}
}

class Consumer extends Thread {
	private ArrayList<Integer> array = null;

	public Consumer(ArrayList<Integer> arr) {
		super();
		array = arr;
	}

	public void run() {

		while (true) {
			try {
				consume();
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		synchronized (array) {

			while (array.isEmpty()) {
				try {
					array.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			Integer item = array.remove(0);
			System.out.println("consumer: " + item);

			array.notify();
		}
	}
}

public class ProducerConsumerDemo {

	public static void main(String args[]) {
		ArrayList<Integer> array = new ArrayList<Integer>();

		Producer prod = new Producer(array);
		Consumer cons = new Consumer(array);

		prod.start();
		cons.start();

		try {
			prod.join();
			cons.join();
		} catch (InterruptedException ex) {
			System.out.println("Thread interrupted.");
			ex.printStackTrace();
		}
	}

}
