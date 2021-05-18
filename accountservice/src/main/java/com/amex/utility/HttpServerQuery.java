package com.amex.utility;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class HttpServerQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertx vertx = Vertx.vertx(); 

	       vertx.createHttpServer()
	        .requestHandler(req -> {
	            String name = req.getParam("name");
	            String message = "Hi " + (name != null && ! name.trim().isEmpty() ? name : "Great") + "!";
	            JsonObject json = new JsonObject()
	                .put("message", message);
	           req.response()
	                .putHeader("Content-Type", "application/json; charset=UTF8")
	                .end(json.encodePrettily());
	        })
	        .listen(8888);
	}

}
