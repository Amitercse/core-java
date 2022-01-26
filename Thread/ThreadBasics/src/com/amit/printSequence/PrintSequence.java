package com.amit.printSequence;

public class PrintSequence implements Runnable {

	private int remainder;
	private int maxNumber;
	private int totalThreads;
	static int counter = 1;
	static Object lock = new Object();

	public PrintSequence(int remainder, int maxNumber, int totalThreads) {
		this.remainder = remainder;
		this.maxNumber = maxNumber;
		this.totalThreads = totalThreads;
	}

	@Override
	public void run() {
		while (counter < maxNumber-(totalThreads-2)) {
			synchronized (lock) {
				while (counter % totalThreads != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(counter + " by thread: " + Thread.currentThread().getName());
				counter++;
				lock.notifyAll();
			}
		}
	}

}
