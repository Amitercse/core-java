package com.amit.future;

import java.util.concurrent.Callable;

public class MyFutureTask implements Callable<String> {

	@Override
	public String call() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "retrieved result";
	}

}
