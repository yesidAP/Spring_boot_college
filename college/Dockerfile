FROM eclipse-temurin:21-jdk-alpine
ARG JAR_FILE=target/college-0.0.1.jar
COPY ${JAR_FILE} app_college.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_college.jar"]