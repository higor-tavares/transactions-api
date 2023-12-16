FROM openjdk:17-jdk-slim-buster
COPY target/transactions-api-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]