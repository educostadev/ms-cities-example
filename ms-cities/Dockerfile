FROM openjdk:14
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 3000
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar", "--server.port=3000"]
