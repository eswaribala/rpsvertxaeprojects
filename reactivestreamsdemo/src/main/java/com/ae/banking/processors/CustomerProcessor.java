package com.ae.banking.processors;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

import com.ae.banking.models.Customer;
import com.ae.banking.models.PlatinumCustomer;

public class CustomerProcessor  extends SubmissionPublisher<PlatinumCustomer> implements Processor<Customer,PlatinumCustomer>{

	private Subscription subscription;
	private Function<Customer,PlatinumCustomer> function;
	
	public  CustomerProcessor(Function<Customer,PlatinumCustomer> function) {
		this.function=function;
	}
	
	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		System.out.println("Entering into Processor Subscription");
		this.subscription=subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Moving on with  Processor Subscription");
		submit((PlatinumCustomer) function.apply(customer));  
	    subscription.request(1);  
		
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		System.out.println(throwable.getMessage());
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println("Processing Done");
	}

}
