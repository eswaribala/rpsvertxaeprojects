package com.amex.utility;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

public class VerticleN extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleN.class);

  @Override
  public void start(final Promise<Void> startPromise) throws Exception {
   // LOG.debug("Start {} with config {}", getClass().getName(), config().toString());
    JsonObject json=new JsonObject()
    .put("id", UUID.randomUUID().toString())
    .put("name", VerticleN.class.getSimpleName());
    LOG.debug("Start {} with config {}", getClass().getName(), json);
    //System.out.println(json);
    startPromise.complete();
  }
}
