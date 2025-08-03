package com.zad.excellence.practice.basic.intercommunication;

import java.util.List;

public class Consumer implements Runnable {

	private List<Integer> sharedTaskQueue;

	public Consumer(List<Integer> sharedTaskQueue) {
		super();
		this.sharedTaskQueue = sharedTaskQueue;

	}

	@Override
	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void consume() throws InterruptedException {
		synchronized (sharedTaskQueue) {
			while (sharedTaskQueue.isEmpty()) {
				System.out.println("Queue is empty, Comsumer moved to waiting state ");
				try {
					sharedTaskQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			Thread.sleep(1000);
			int consumed = sharedTaskQueue.remove(0);
			System.out.println("Message consumed is : " + consumed);
			sharedTaskQueue.notifyAll();
		}

	}

}
