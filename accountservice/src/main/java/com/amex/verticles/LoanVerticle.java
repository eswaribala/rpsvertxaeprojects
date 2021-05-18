package com.amex.verticles;

import io.vertx.core.AbstractVerticle;

public class LoanVerticle extends AbstractVerticle{

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("Entering into  Loan Verticle");
		/*
		vertx.deployVerticle(new ForexVerticle(),stringAsyncResult->{
			System.out.println("Forex verticle deployment done");
		});
		*/
		vertx.eventBus().publish("EMINotification", "Due Date Approaching, Keep Sufficient Balance");
		vertx.eventBus().send("EMINotification", "Overdue, Keep Sufficient Balance");
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("Stopping Verticle");
	}

	
}
