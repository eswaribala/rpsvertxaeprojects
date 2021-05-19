package com.amex.eventbuses;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amex.utility.VerticleN;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class PointToPointExample {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new Sender());
    vertx.deployVerticle(new Sender1());
    vertx.deployVerticle(Receiver.class.getName(), new DeploymentOptions()
            .setInstances(4)
            .setConfig(new JsonObject()
              .put("id", UUID.randomUUID().toString())
              .put("name", Receiver.class.getSimpleName())
            ));
  }

  public static class Sender extends AbstractVerticle {
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      vertx.setPeriodic(1000, id -> {
        // Send a message every second
        vertx.eventBus().send("Note", "Sender Sending a message..."+new Random().nextInt(1000));
      });
    }
  }

  
  public static class Sender1 extends AbstractVerticle {
	    @Override
	    public void start(final Promise<Void> startPromise) throws Exception {
	      startPromise.complete();
	      vertx.setPeriodic(1000, id -> {
	        // Send a message every second
	        vertx.eventBus().send("Note", "Sender1 Sending a message..."+new Random().nextInt(1000));
	      });
	    }
	  }
  public static class Receiver extends AbstractVerticle {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      JsonObject json=new JsonObject()
              .put("id", UUID.randomUUID().toString())
              .put("name", Receiver.class.getSimpleName());
            
      vertx.eventBus().<String>consumer("Note", message -> {
        LOG.debug("Received: {}->{}",json,message.body());
      });
     
    }
  }
}
