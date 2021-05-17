package com.ae.banking.utility;

import java.time.LocalDate;
import java.util.concurrent.Callable;

import com.ae.banking.models.CreditCard;

import rx.Observable;

public class ObservableFromCallable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//callable		
		Callable<CreditCard> callable=()->{
			return new CreditCard(239649732L,
				"Parameswari",500000,LocalDate.now());};
		Observable<CreditCard> observable=Observable.fromCallable(callable);		
		observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(), 
			    () -> System.out.println("Done"));
	}

}
