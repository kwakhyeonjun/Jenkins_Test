FROM openjdk:11

ARG JAR_FILE=build/libs/test-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8880

ENTRYPOINT ["java", "-jar", "/app.jar"]