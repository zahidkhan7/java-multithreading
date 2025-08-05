package com.zad.excellence.practice.standard.execution;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.zad.excellence.practice.standard.handler.RejectedTaskHandler;
import com.zad.excellence.practice.standard.tasks.SimpleRejectedTask;

/*
Sample Example is Taken from :
https://howtodoinjava.com/java/multi-threading/executor-rejectedexecutionhandler/
 */
public class RejectedTaskHandlerExample {

	public static void main(String[] args) {
		RejectedTaskHandlerExample instance = new RejectedTaskHandlerExample();
		instance.rejectedTaskHandlerDemonstration();

	}

	private void rejectedTaskHandlerDemonstration() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
				.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		RejectedTaskHandler handler = new RejectedTaskHandler();
		executor.setRejectedExecutionHandler(handler);
		for (int i = 0; i < 10; i++) {
			SimpleRejectedTask rejectedTask = new SimpleRejectedTask("Task-" + i);
			executor.execute(rejectedTask);
		}

		executor.prestartAllCoreThreads();
		// shut down the executor so that new tasks will be rejected
		executor.shutdown();

		SimpleRejectedTask task = new SimpleRejectedTask("Rejected task");
		executor.execute(task);

	}

	@SuppressWarnings("unused")
	private void findProcessor() {
		int processor = Runtime.getRuntime().availableProcessors();
		System.out.println("System has processor : " + processor);
	}
}
