package com.amex.verticles;

import io.vertx.core.AbstractVerticle;

public class LoanVerticle extends AbstractVerticle{

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("Entering into Verticle");
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("Stopping Verticle");
	}

	
}
