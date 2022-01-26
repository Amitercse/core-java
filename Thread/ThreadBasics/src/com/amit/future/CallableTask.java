package com.amit.future;

import java.util.Queue;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

	Queue<String> queue;

	public CallableTask(Queue<String> queue) {
		this.queue = queue;
	}

	@Override
	public String call() throws Exception {
		String result = "";
		if (!queue.isEmpty()) {
			result = queue.poll();
		}
		return result + " processed by " + Thread.currentThread().getName();
	}
}
