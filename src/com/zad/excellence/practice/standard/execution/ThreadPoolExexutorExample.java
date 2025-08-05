package com.zad.excellence.practice.standard.execution;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 	Sample is taken from :
 	https://www.educative.io/courses/java-multithreading-for-senior-engineering-interviews/threadpoolexecutor
 */

public class ThreadPoolExexutorExample {

	public static void main(String[] args) {
		ThreadPoolExexutorExample instance = new ThreadPoolExexutorExample();
		instance.simpleDemonstrationOfThreadPoolExecutor();

	}

	private void simpleDemonstrationOfThreadPoolExecutor() {

		// create an instance of the ThreadPoolExecutor
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.MINUTES,
				new LinkedBlockingDeque<>(3), new ThreadPoolExecutor.DiscardPolicy());

		for (int i = 0; i < 2; i++) {
			try {
				threadPoolExecutor.submit(new Runnable() {
					@Override
					public void run() {
						System.out.println("This is worker thread " + Thread.currentThread().getName() + " executing");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException ie) {
							System.out.println(ie.getMessage());
						}
					}
				});
			} finally {
				threadPoolExecutor.shutdown();
			}

		}
	}

}
