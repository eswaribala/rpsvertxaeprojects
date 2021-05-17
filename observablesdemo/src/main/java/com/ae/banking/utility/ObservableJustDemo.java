package com.ae.banking.utility;

import java.time.LocalDate;
import java.util.Random;

import com.ae.banking.models.CreditCard;

import rx.Observable;

public class ObservableJustDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //string
		Observable.just("American Express").subscribe(System.out::println);
		//characters
		Observable.just("A", "m", "e", "r", "i", "c").subscribe(System.out::println);
		//Object
		Observable.just(new CreditCard(239649732L,
				"Parameswari",500000,LocalDate.now()))		
		.map(c->c.getCustomerName()+","+c.getTransactionLimit())
		.subscribe(System.out::println);
		
	}

}
