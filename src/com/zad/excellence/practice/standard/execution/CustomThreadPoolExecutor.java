package com.zad.excellence.practice.standard.execution;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* 	
	Sample example taken from: 
	https://howtodoinjava.com/java/multi-threading/how-to-use-blockingqueue-and-threadpoolexecutor-in-java/
	https://howtodoinjava.com/java/collections/java-queue-interface/
*/

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

	public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);

	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		System.out.println("Perform beforeExecute() logic");
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if (t != null) {
			System.out.println("Perform exception handler logic");
		}
		System.out.println("Perform afterExecute() logic");
	}

}
