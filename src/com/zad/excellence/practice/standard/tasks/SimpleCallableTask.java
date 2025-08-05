package com.zad.excellence.practice.standard.tasks;

import java.util.concurrent.Callable;

public class SimpleCallableTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("This is Callable Task Implementation and Work for String Type");
		return "Callable";
	}
}
