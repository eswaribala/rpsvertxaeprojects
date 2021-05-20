###
# vert.x docker example using a Java verticle
# To build:
#  docker build -t sample/books-java .
# To run:
#   docker run -t -i -p 7070:8888 sample/books-java
###

# Extend vert.x image
FROM vertx/vertx3

ENV VERTICLE_NAME com.amex.booksapi.jdbc.JDBCMainVerticle
ENV VERTICLE_FILE target/booksapi-1.0.0-SNAPSHOT.jar

# Set the location of the verticles
ENV VERTICLE_HOME /usr/verticles

EXPOSE 8888

# Copy your verticle to the container
COPY $VERTICLE_FILE $VERTICLE_HOME/

# Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec vertx run $VERTICLE_NAME -cp $VERTICLE_HOME/*"]
