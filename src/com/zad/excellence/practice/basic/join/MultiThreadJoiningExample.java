package com.zad.excellence.practice.basic.join;

import com.zad.excellence.practice.basic.tasks.RunnableTaskWithSleep;
/*
	Sample Concept Taken from :
	https://codingnomads.com/java-thread-join
*/

public class MultiThreadJoiningExample {
	public static void main(String[] args) {
		MultiThreadJoiningExample instance = new MultiThreadJoiningExample();
		instance.simpleMultithreadJoinExample();
		instance.simpleMultithreadWithoutJoinExample();
		instance.simpleMultithreadJoinWithTimeExample();
	}

	private void simpleMultithreadJoinExample() {
		Thread thread1 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep1");
		Thread thread2 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep2");
		Thread thread3 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep3");
		thread1.start();
		try {
			System.out.println("Main Thread: " + Thread.currentThread().getName());
			thread1.join();
		} catch (Exception ex) {
			System.out.println("Exception has been caught" + ex);
		}
		thread2.start();
		try {
			System.out.println("Main Thread: " + Thread.currentThread().getName());
			thread2.join();
		} catch (Exception ex) {
			System.out.println("Exception has been  caught" + ex);
		}
		System.out.println("Main Thread: " + Thread.currentThread().getName());
		thread3.start();
		try {
			System.out.println("Main Thread: " + Thread.currentThread().getName());
			thread3.join();
		} catch (Exception ex) {
			System.out.println("Exception has been  caught" + ex);
		}
		System.out.println("Main Thread: " + Thread.currentThread().getName());
		System.out.println("====================== END ==============================");
	}

	private void simpleMultithreadWithoutJoinExample() {
		Thread thread1 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep1");
		Thread thread2 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep2");
		Thread thread3 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep3");
		System.out.println("Main Thread: " + Thread.currentThread().getName());
		thread1.start();
		thread2.start();
		thread3.start();
		System.out.println("Main Thread: " + Thread.currentThread().getName());
		System.out.println("====================== END ==============================");
	}

	private void simpleMultithreadJoinWithTimeExample() {
		Thread thread1 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep1");
		Thread thread2 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep2");
		Thread thread3 = new Thread(new RunnableTaskWithSleep(), "RunnableTaskWithSleep3");
		thread1.start();
		try {
			System.out.println("Main Thread: " + Thread.currentThread().getName());
			thread1.join(2000);
		} catch (Exception ex) {
			System.out.println("Exception has been caught" + ex);
		}
		System.out.println("Main Thread: " + Thread.currentThread().getName());
		thread2.start();
		try {
			System.out.println("Main Thread: " + Thread.currentThread().getName());
			thread2.join(2000);
		} catch (Exception ex) {
			System.out.println("Exception has been  caught" + ex);
		}
		System.out.println("Main Thread: " + Thread.currentThread().getName());
		thread3.start();
		System.out.println("====================== END ==============================");
	}
}
