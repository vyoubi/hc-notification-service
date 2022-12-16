FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/hc-notification-service.jar
ADD ${JAR_FILE} hc-notification-service.jar
EXPOSE 5007
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","hc-notification-service.jar"]
