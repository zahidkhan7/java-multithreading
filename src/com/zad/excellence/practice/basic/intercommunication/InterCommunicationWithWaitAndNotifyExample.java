package com.zad.excellence.practice.basic.intercommunication;

import java.util.ArrayList;
import java.util.List;
/*
	Sample Concept Taken from :
	https://stackoverflow.com/questions/68652663/producer-and-consumer-thread-working-unexpectedly
*/

public class InterCommunicationWithWaitAndNotifyExample {
	public static void main(String args[]) {
		InterCommunicationWithWaitAndNotifyExample instance = new InterCommunicationWithWaitAndNotifyExample();
		instance.interCommunicationWithSharedResource();
	}

	private void interCommunicationWithSharedResource() {
		List<Integer> sharedTaskQueue = new ArrayList<Integer>();
		int MAX_CAPACITY = 5;
		Thread producerThread = new Thread(new Producer(sharedTaskQueue, MAX_CAPACITY));
		Thread consumerThread = new Thread(new Consumer(sharedTaskQueue));
		producerThread.start();
		consumerThread.start();
	}
}
