package com.zad.excellence.practice.standard.tasks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import com.zad.excellence.practice.standard.model.Customer;
import com.zad.excellence.practice.standard.utils.DataSetPreperationUtil;

public class CustomerCallableTask implements Callable<Customer> {

	@Override
	public Customer call() throws Exception {
		List<Customer> filterCustomers = DataSetPreperationUtil.buildCustomerList().stream()
				.filter(customer -> customer.getCustomerId() == generatedCustomerId()).collect(Collectors.toList());
		if (null != filterCustomers && filterCustomers.size() > 0) {
			return filterCustomers.get(0);
		}
		return new Customer(101, "Harry", "Shocking@abc.com", "8974758724");
	}

	private int generatedCustomerId() {
		Random random = new Random();
		int randomNumber = random.nextInt(110 - 100 + 1) + 100;
		return randomNumber;
	}

}
