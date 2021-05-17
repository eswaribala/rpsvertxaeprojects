package com.ae.banking.utility;

import java.util.concurrent.SubmissionPublisher;

import com.ae.banking.helpers.CustomerDataHelper;
import com.ae.banking.models.Customer;
import com.ae.banking.subscribers.CustomerSubscriber;

public class ReactiveAppPubSubDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        //publisher 
		SubmissionPublisher<Customer> publisher= new SubmissionPublisher<Customer>();
		//subscriber
		CustomerSubscriber subscriber=new CustomerSubscriber();
		//subscriber registered with publisher
		publisher.subscribe(subscriber);
		//publishing the data
	   CustomerDataHelper.getAllCustomers().stream().forEach(c->publisher.submit(c));
	   
	  while( CustomerDataHelper.getAllCustomers().size()!=subscriber.getCounter())
		  Thread.sleep(1000);
		
		publisher.close();
		
	}

}
