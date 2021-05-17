package com.ae.banking.utility;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ae.banking.models.CreditCard;

import rx.Observable;

public class ObservableFromFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Thread pool
		ScheduledExecutorService scheduledExecutorService=Executors.newSingleThreadScheduledExecutor();
		
		Future<CreditCard> future=scheduledExecutorService.schedule(()->new CreditCard(239649732L,
				"Parameswari",500000,LocalDate.now()), 1, TimeUnit.NANOSECONDS);
		
		Observable<CreditCard> observable=Observable.from(future);		
		observable.subscribe(item -> System.out.println(item.getCustomerName()), error -> error.printStackTrace(), 
			    () -> System.out.println("Done"));
		
		
	}

}
