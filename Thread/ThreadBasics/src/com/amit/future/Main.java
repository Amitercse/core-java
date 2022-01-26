package com.amit.future;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {

	public static void main(String[] args) {
		Callable<String> callable= new MyFutureTask();
		FutureTask<String> futureTask= new FutureTask<String>(callable);
		Thread t1= new Thread(futureTask);
		t1.start();
		String result=null;
		try {
			result = futureTask.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		Queue<String> queue= new ArrayDeque<String>();
		for(int i=1; i<=10; i++)
		{
			queue.add("String:"+i);
		}
		ExecutorService service= Executors.newFixedThreadPool(3);
		Callable<String> call= new CallableTask(queue);
		while(!queue.isEmpty())
		{
			Future<String> output= service.submit(call);
			try {
				System.out.println(output.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
