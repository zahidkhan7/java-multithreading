package com.zad.excellence.practice.standard.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.zad.excellence.practice.standard.model.Customer;

public class DataSetPreperationUtil {

	public static void main(String[] args) {
		DataSetPreperationUtil instance = new DataSetPreperationUtil();
		DataSetPreperationUtil.generateCustomerId();
		DataSetPreperationUtil.buildCustomerList();
		
	}

	public static List<Customer> buildCustomerList() {
		List<Customer> customerList = new ArrayList<Customer>();

		customerList.add(new Customer(101, "Shaid Khan", "shahidkhan@gmail.com", "+918981396845"));

		customerList.add(new Customer(102, "Mujeeb Ahmad", "mujeebahmad@gmail.com", "+918981396825"));
		customerList.add(new Customer(103, "Basith Syed", "syedbasith@gmail.com", "+918981396855"));
		customerList.add(new Customer(104, "Anup Kumar", "anupkumar@gmail.com", "+918981396885"));
		customerList.add(new Customer(105, "khairan Syed", "khairansyed@gmail.com", "+918981396895"));
		customerList.add(new Customer(106, "Multan Khaja", "khajamultan@gmail.com", "+918881396845"));
		customerList.add(new Customer(107, "Mahreen Zafar", "zafarmahreen@gmail.com", "+918781396845"));

		customerList.add(new Customer(108, "Afroz Zafar", "afrozzafar@gmail.com", "+919881396845"));
		customerList.add(new Customer(109, "Salma Sitara", "sitarasalma@gmail.com", "+919811396845"));

		return customerList;

	}

	private static int generateCustomerId() {
		return randomRangeThreadLocalRandom(100, 110);
	}

	public static int randomRangeThreadLocalRandom(int start, int end) {
		int number = ThreadLocalRandom.current().nextInt(start, end);
		System.out.println("Number Generated is : " + number);
		return number;
	}

}
