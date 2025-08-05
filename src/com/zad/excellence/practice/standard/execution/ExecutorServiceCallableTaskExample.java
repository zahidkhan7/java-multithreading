package com.zad.excellence.practice.standard.execution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.zad.excellence.practice.basic.tasks.SimpleCallableTask;
import com.zad.excellence.practice.standard.model.Customer;
import com.zad.excellence.practice.standard.tasks.CustomerCallableTask;

public class ExecutorServiceCallableTaskExample {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorServiceCallableTaskExample instance = new ExecutorServiceCallableTaskExample();
		instance.callableExecutionWithCustomerResponse();

	}

	private void callableExecutionWithFixedThreadPool() {
		ExecutorService fixedThreadPoolExecutor = Executors.newFixedThreadPool(10);
		List<Future<String>> futureList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<String> future = fixedThreadPoolExecutor.submit(new SimpleCallableTask());
			futureList.add(future);
		}
		List<String> names = futureList.stream().map(future -> getResponseFromFuture(future))
				.collect(Collectors.toList());
		System.out.println("The Callable Task Result is :" + names.parallelStream().collect(Collectors.joining(":")));
	}

	private String getResponseFromFuture(Future<String> future) {
		try {
			return (String) future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void callableExecutionWithCustomerResponse() {
		ExecutorService fixedThreadPoolExecutor = Executors.newFixedThreadPool(10);
		List<Future<Customer>> futureList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<Customer> future = fixedThreadPoolExecutor.submit(new CustomerCallableTask());
			futureList.add(future);
		}
		List<Customer> customers = futureList.stream().map(future -> praseResponseFromFuture(future))
				.collect(Collectors.toList());
		customers.stream()
				.forEach(customer -> System.out.println(customer.getCustomerId() + " : " + customer.getCustomerName()));
	}

	private Customer praseResponseFromFuture(Future<Customer> future) {
		try {
			return (Customer) future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

}
