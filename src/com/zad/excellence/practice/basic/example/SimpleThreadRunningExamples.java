package com.zad.excellence.practice.basic.example;

public class SimpleThreadRunningExamples {
	public static void main(String[] args) {
		SimpleThreadRunningExamples instance = new SimpleThreadRunningExamples();
		instance.simpleThreadExecutionExample();
		instance.simpleRunnableExecutionExample();
	}

	private void simpleThreadExecutionExample() {
		CustomPrinterThread printer = new CustomPrinterThread();
		printer.start();
		System.out.println("Main thread is running....");
	}

	private void simpleRunnableExecutionExample() {
		CustomPrinterRunnable targetPrinter = new CustomPrinterRunnable();
		Thread thread = new Thread(targetPrinter);
		thread.start();
		System.out.println("Main thread is running....");
	}
}
