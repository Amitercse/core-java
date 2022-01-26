package com.amit.singleton;

public class Main {

	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println("are both instance equal: " + (instance1 == instance2));
	}
}
