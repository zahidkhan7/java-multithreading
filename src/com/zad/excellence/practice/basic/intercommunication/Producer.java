package com.zad.excellence.practice.basic.intercommunication;

import java.util.List;

public class Producer implements Runnable {

	private List<Integer> sharedTaskQueue;
	private final int MAX_CAPACITY;

	public Producer(List<Integer> taskQueue, int maxCapacity) {
		super();
		this.sharedTaskQueue = taskQueue;
		this.MAX_CAPACITY = maxCapacity;
	}

	@Override
	public void run() {
		int counter = 0;
		while (true) {
			try {
				produce(counter++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void produce(int count) throws InterruptedException {
		synchronized (sharedTaskQueue) {
			while (sharedTaskQueue.size() == MAX_CAPACITY) {
				System.out.println("Queue is Full, Producer moved to waiting state ");
				try {
					sharedTaskQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Thread.sleep(1000);
			System.out.println("Produced : " + count);
			sharedTaskQueue.add(count);
			sharedTaskQueue.notifyAll();
		}

	}

}
