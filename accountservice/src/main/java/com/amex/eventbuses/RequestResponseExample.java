package com.amex.eventbuses;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amex.eventbuses.PointToPointExample.Receiver;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class RequestResponseExample {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new RequestVerticle());
    vertx.deployVerticle(ResponseVerticle.class.getName(),new DeploymentOptions()
            .setInstances(4)
            .setConfig(new JsonObject()
              .put("id", UUID.randomUUID().toString())
              .put("name", ResponseVerticle.class.getSimpleName())
            ));
  }

  public static class RequestVerticle extends AbstractVerticle {

    private static final Logger LOG = LoggerFactory.getLogger(RequestVerticle.class);
    static final String ADDRESS = "my.request.address";

    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      var eventBus = vertx.eventBus();
      final String message = "Send->Branch->Code!";
      LOG.debug("Sending: {}", message);
      eventBus.<String>request(ADDRESS, message, reply -> {
        LOG.debug("Response: {}", reply.result().body());
      });
    }
  }

  public static class ResponseVerticle extends AbstractVerticle {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseVerticle.class);

    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      vertx.eventBus().<String>consumer(RequestVerticle.ADDRESS, message -> {
        LOG.debug("Received Message: {}", message.body());
        String[] messages=message.body().split("->");
        message.reply("Branch Code!"+messages[0]+new Random().nextInt(10000));
      });
    }
  }
}
