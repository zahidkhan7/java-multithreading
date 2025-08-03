package com.zad.excellence.practice.basic.intercommunication;

public class ResourceNotifierTask implements Runnable {

	private MessageResource message;

	public ResourceNotifierTask(MessageResource message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " started");
		try {
			Thread.sleep(3000);
			synchronized (message) {
				message.setMessage(threadName + " work done");
				// msg.notify();
				message.notifyAll();

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
