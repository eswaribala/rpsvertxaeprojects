package com.amex.utility;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class HttpServerJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertx vertx = Vertx.vertx(); 

	       vertx.createHttpServer()
	        .requestHandler(req -> {
	            JsonObject json = new JsonObject()
	                .put("message", "Rocking with JSON");
	           req.response()
	                .putHeader("Content-Type", "application/json; charset=UTF8")
	                .end(json.encodePrettily());
	        })
	        .listen(8888);
	}

}
