package com.amit.executor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService service= Executors.newFixedThreadPool(4);
		Queue<String> queue= new ArrayDeque<String>();
		for(int i=1; i<=10; i++)
		{
			queue.add("string:"+i);
		}
		while(!queue.isEmpty())
		{
			service.execute(new ThreadPoolExecutor(queue));
		}
		
	}
}
