package com.ae.banking.subscribers;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.ae.banking.models.Customer;
import com.ae.banking.models.PlatinumCustomer;

public class PlatinumCustomerSubscriber implements Subscriber<PlatinumCustomer> {

	private Subscription subscription;
	private int counter;
	
	public int getCounter() {
		return counter;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		System.out.println("Start Subscribing....");
		this.subscription=subscription;
		this.subscription.request(1);
		System.out.println("Subscribed for data....");
	}

	@Override
	public void onNext(PlatinumCustomer item) {
		// TODO Auto-generated method stub
		System.out.println("Data arriving....");
		counter++;
		this.subscription.request(1);
		System.out.println("OnNext Subscribed for data...."+counter);
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		System.out.println("Data Error Ocurred....");
		System.out.println(throwable.getMessage());
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println("Data arrived.... and Closing");
	}

}
