package com.ae.banking.utility;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import com.ae.banking.helpers.CustomerDataHelper;
import com.ae.banking.models.Customer;
import com.ae.banking.models.PlatinumCustomer;
import com.ae.banking.processors.CustomerProcessor;
import com.ae.banking.subscribers.PlatinumCustomerSubscriber;

public class ReactivePubSubProcessor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		SubmissionPublisher<Customer> publisher = new SubmissionPublisher<>();

		// Create Processor
		CustomerProcessor transformProcessor = new CustomerProcessor(s -> {
			return new PlatinumCustomer(s.getCustomerId(), s.getName(),s.getPhoneNo(),null );
		});

		//Create End Subscriber
		PlatinumCustomerSubscriber subs = new PlatinumCustomerSubscriber();

		//Create chain of publisher, processor and subscriber
		publisher.subscribe(transformProcessor); // publisher to processor
		transformProcessor.subscribe(subs); // processor to subscriber

		List<Customer> customers = CustomerDataHelper.getAllCustomers();

		// Publish items
		System.out.println("Publishing Items to Subscriber");
		customers.stream().forEach(i -> publisher.submit(i));

		// Logic to wait for messages processing to finish
		while (customers.size() != subs.getCounter()) {
			Thread.sleep(10);
		}

		// Closing publishers
		publisher.close();
		transformProcessor.close();

		System.out.println("Exiting the app");
	}

}
