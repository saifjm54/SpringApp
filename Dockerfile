FROM openjdk:17-jdk-slim
COPY target/spring-ci-example-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]