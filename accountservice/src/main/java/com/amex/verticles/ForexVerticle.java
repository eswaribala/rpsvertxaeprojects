package com.amex.verticles;

import io.vertx.core.AbstractVerticle;

public class ForexVerticle extends AbstractVerticle{

	private String name;
	
	public ForexVerticle(String name) {
		this.name=name;
		}
		
	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("Entering into Forex Verticle");
		vertx.eventBus().consumer("EMINotification",message->{
			System.out.println("Received By"+this.name+"->"+message);
		});
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
	}



}
