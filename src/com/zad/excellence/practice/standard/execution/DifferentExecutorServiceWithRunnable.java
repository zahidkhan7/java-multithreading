package com.zad.excellence.practice.standard.execution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.zad.excellence.practice.basic.tasks.SimpleRunnableTask;
import com.zad.excellence.practice.standard.tasks.ScheduleTask;

public class DifferentExecutorServiceWithRunnable {

	public static void main(String[] args) {
		DifferentExecutorServiceWithRunnable instance = new DifferentExecutorServiceWithRunnable();
		//instance.simpleExecutorServiceWithSingleThread();
		//instance.simpleExecutorServiceWithFixedThreadPool();
		//instance.simpleExecutorServiceWithCachedThreadPool();
		instance.simpleExecutorServiceWithScheduleThreadPool();
	}

	private void simpleExecutorServiceWithSingleThread() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for(int i=0; i<10; i++)
		{
			singleThreadExecutor.execute(new SimpleRunnableTask());
		}
		System.out.println(" Single Thread Pool Execution Completed : ");			
		singleThreadExecutor.shutdown();
	}
	
	private void simpleExecutorServiceWithFixedThreadPool() {
		ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			fixedThreadExecutor.execute(new SimpleRunnableTask());
		}
		System.out.println(" Fixed Thread Pool Execution Completed : ");
		fixedThreadExecutor.shutdown();
	}
	
	private void simpleExecutorServiceWithCachedThreadPool() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++)
		{
			cachedThreadPool.execute(new SimpleRunnableTask());
		}
		cachedThreadPool.shutdown();
	}
	
	private void simpleExecutorServiceWithScheduleThreadPool() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		
		//executorService.schedule(new ScheduleTask(), 5, TimeUnit.SECONDS);
		
		//executorService.scheduleAtFixedRate(new ScheduleTask(), 2, 5, TimeUnit.SECONDS);
		
		executorService.scheduleWithFixedDelay(new ScheduleTask(), 2, 2, TimeUnit.SECONDS);
	}

}
