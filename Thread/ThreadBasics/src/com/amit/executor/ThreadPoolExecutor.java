package com.amit.executor;

import java.util.Queue;

public class ThreadPoolExecutor implements Runnable{

	Queue<String> queue;
	
	public ThreadPoolExecutor(Queue<String> queue) {
		this.queue= queue;
	}

	@Override
	public void run() {
		if(!queue.isEmpty())
		{
			System.out.println(queue.poll()+" by "+ Thread.currentThread().getName());
		}
	}
	
}
