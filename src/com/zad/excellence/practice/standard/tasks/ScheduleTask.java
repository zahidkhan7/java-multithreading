package com.zad.excellence.practice.standard.tasks;

public class ScheduleTask implements Runnable {

	@Override
	public void run() {
		System.out.println("This is Schedule Task for Execution: " + Thread.currentThread().getName());
		
	}

}
