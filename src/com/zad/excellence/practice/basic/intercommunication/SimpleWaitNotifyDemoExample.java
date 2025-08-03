package com.zad.excellence.practice.basic.intercommunication;

public class SimpleWaitNotifyDemoExample {
	public static void main(String args[]) {
		SimpleWaitNotifyDemoExample instance = new SimpleWaitNotifyDemoExample();
		instance.simpleInterCommunicationExample();
	}

	private void simpleInterCommunicationExample() {
		MessageResource message = new MessageResource("Generic Message");
		ResourceWaiterTask waiter1 = new ResourceWaiterTask(message);
		new Thread(waiter1, "Waiter1").start();
		ResourceWaiterTask waiter2 = new ResourceWaiterTask(message);
		new Thread(waiter2, "Waiter2").start();
		ResourceNotifierTask notifier = new ResourceNotifierTask(message);
		new Thread(notifier, "Notifier").start();
	}
}
