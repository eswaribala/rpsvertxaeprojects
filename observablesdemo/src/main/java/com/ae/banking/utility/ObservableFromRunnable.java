package com.ae.banking.utility;

import java.time.LocalDate;

import com.ae.banking.models.CreditCard;

import io.reactivex.Completable;

public class ObservableFromRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable runnable=()->System.out.println(new CreditCard(239649732L,
				"Parameswari",500000,LocalDate.now()));
		//Observable type  completable
		Completable completable=Completable.fromRunnable(runnable);
		completable.subscribe();
	}

}
