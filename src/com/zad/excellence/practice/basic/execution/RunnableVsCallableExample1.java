package com.zad.excellence.practice.basic.execution;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.zad.excellence.practice.basic.tasks.SimpleCallableTask;
import com.zad.excellence.practice.basic.tasks.SimpleRunnableTask;

public class RunnableVsCallableExample1 {
	public static void main(String args[]) {
		RunnableVsCallableExample1 instance = new RunnableVsCallableExample1();
		instance.executeRunnableTaskUsingThread();
		instance.executeRunnableTaskUsingExecutorService();
		instance.executeCallableTaskUsingExecutorService();
	}
	// Runnable Task can be executed both by Thread and ExecutorService.

	private void executeRunnableTaskUsingThread() {
		SimpleRunnableTask runnableTask = new SimpleRunnableTask();
		Thread thread = new Thread(runnableTask);
		thread.start();
	}

	private void executeRunnableTaskUsingExecutorService() {
		SimpleRunnableTask runnableTask = new SimpleRunnableTask();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(runnableTask);
		executorService.shutdown();
	}
	/*
	 * <============================================================================
	 * ====>
	 */
	// Callable Task can be executed only by ExecutorService not by Thread.
	/*
	 * private void executeCallableTaskUsingThread() { SimpleCallableTask
	 * callableTask = new SimpleCallableTask(); Thread thread = new
	 * Thread(callableTask); thread.start(); }
	 */

	private void executeCallableTaskUsingExecutorService() {
		SimpleCallableTask callableTask = new SimpleCallableTask();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<String> future = executorService.submit(callableTask);
		try {
			String response = future.get();
			System.out.println(" The Response received from future : " + response);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}
}
