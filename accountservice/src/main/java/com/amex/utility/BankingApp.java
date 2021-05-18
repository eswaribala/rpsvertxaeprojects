package com.amex.utility;

import com.amex.verticles.LoanVerticle;

import io.vertx.core.Vertx;

public class BankingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Vertx vertx=Vertx.vertx();
        vertx.deployVerticle(new LoanVerticle());
		
	}

}
