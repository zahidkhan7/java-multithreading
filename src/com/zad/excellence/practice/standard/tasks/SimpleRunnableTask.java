package com.zad.excellence.practice.standard.tasks;

public class SimpleRunnableTask implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("This is Runnable Task Implementation");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
