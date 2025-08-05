package com.zad.excellence.practice.standard.execution;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.zad.excellence.practice.basic.tasks.CustomDemoTask;

public class CustomThreadPoolExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		CustomThreadPoolExecutorDemo instance = new CustomThreadPoolExecutorDemo();
		instance.implementationOfCustomThreadPoolExecutor();

	}

	private void implementationOfCustomThreadPoolExecutor() throws InterruptedException {
		BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>();

		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS, blockingQueue);
		
		// Let start all core threads initially
		executor.prestartAllCoreThreads();
		
		for (int i = 1; i <= 10; i++) {
			blockingQueue.offer(new CustomDemoTask("Task " + i));
		}
		executor.shutdown();
		executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
	}

}
