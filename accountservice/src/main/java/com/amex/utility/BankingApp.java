package com.amex.utility;

import com.amex.verticles.ForexVerticle;
import com.amex.verticles.LoanVerticle;

import io.vertx.core.Vertx;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class BankingApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        Vertx vertx=Vertx.vertx();
		/*
		 * vertx.deployVerticle(new LoanVerticle(),new Handler<AsyncResult<String>>() {
		 * 
		 * public void handle(AsyncResult<String> stringAsyncResult) {
		 * System.out.println("Banking Verticle deployment completed"); } });
		 */
        vertx.deployVerticle(new ForexVerticle("F1"),stringAsyncResult->{
        	System.out.println("Forex Verticle deployment completed");
        });
        
        vertx.deployVerticle(new ForexVerticle("F2"),stringAsyncResult->{
        	System.out.println("Forex Verticle deployment completed");
        });
        
        Thread.sleep(3000);
        
        vertx.deployVerticle(new LoanVerticle(),stringAsyncResult->{
        	System.out.println("Banking Verticle deployment completed");
        });
        
        
       
        
		
	}

}
