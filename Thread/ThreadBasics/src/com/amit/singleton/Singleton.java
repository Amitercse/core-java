package com.amit.singleton;

public class Singleton {

	private static volatile Singleton instance;
	static Object lock = new Object();

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (lock) {
				instance = new Singleton();
			}
		}
		return instance;
	}
}
