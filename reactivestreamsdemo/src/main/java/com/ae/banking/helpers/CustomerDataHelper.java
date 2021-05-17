package com.ae.banking.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ae.banking.models.Customer;

public class CustomerDataHelper {

	public static List<Customer> getAllCustomers(){
		List<Customer> customers=new ArrayList<Customer>();
		for(int i=0;i<100;i++)
		{
		customers.add(new Customer(Long.parseLong(String.valueOf(new Random().nextInt(1000000))),
				"customer"+i,435678346L));
		}
		
		return customers;
	}
	
	
}
