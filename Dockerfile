# declare the base image - here is a light weight JDK 8 setup
FROM openjdk:8-jdk-alpine

# copy the generate JAR into the container to run
COPY /target/stripe-commerce-api.jar stripe-commerce-api.jar

EXPOSE 8080

# Run the JAR when we run the container, thus executing the app
ENTRYPOINT ["java", "-jar", "stripe-commerce-api.jar"]