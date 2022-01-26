package com.amit.printSequence;

public class Main {

	public static void main(String[] args) {
		Runnable r1= new PrintSequence(1, 20, 5);
		Runnable r2= new PrintSequence(2, 20, 5);
		Runnable r3= new PrintSequence(3, 20, 5);
		Runnable r4= new PrintSequence(4, 20, 5);
		Runnable r5= new PrintSequence(0, 20, 5);
		Thread t1= new Thread(r1,"thread-1");
		Thread t2= new Thread(r2, "thread-2");
		Thread t3= new Thread(r3, "thread-3");
		Thread t4= new Thread(r4, "thread-4");
		Thread t5= new Thread(r5, "thread-5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
