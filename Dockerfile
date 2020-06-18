FROM openjdk:13-jdk-alpine
ADD build/libs/*.jar app.jar
#EXPOSE 80
#ENV SERVER_PORT=80
ENTRYPOINT ["java", "-jar", "/app.jar"]







