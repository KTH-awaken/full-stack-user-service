FROM openjdk:17-jdk-slim

VOLUME /tmp

EXPOSE 8081

COPY --chown=appuser:appuser target/**.jar /home/appuser/app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

