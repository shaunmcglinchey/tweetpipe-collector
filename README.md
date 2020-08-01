TweetPipe
==============
Spring Boot web application with Twitter hosepipe integration - filters an incoming Twitter stream 
by a set of desired keywords and pushes the corresponding tweets to a destination Kafka topic

Technologies used
--------------
* Java 8
* Spring Boot 2.*
* Maven
* Kafka
* Twitter4J
* Lombok
* Spring-Kafka


Running instructions
--------------------
The project can be run from within an IDE (such as IntelliJ) or directly from the command-line, like so:
* Replace placeholder values in twitter4j.properties with Twitter API credentials
* Set Twitter terms to track via application.yml kafka.track.query.terms property
* Set destination Kafka topic via application.yml kafka.topic property
* mvn clean spring-boot:run

* Once the embedded server has started the service will connect to the Twitter stream and retrieve tweets matching 
the defined query track terms and push those tweets to the destination Kafka topic
