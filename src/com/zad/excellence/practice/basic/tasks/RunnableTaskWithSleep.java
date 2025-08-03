package com.zad.excellence.practice.basic.tasks;

public class RunnableTaskWithSleep implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Current Thread: " + Thread.currentThread().getName() + " Count is : " + i);
			} catch (Exception ex) {
				System.out.println("Exception has been caught" + ex);
			}
		}
	}
}
