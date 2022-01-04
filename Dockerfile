FROM openjdk:8-alpine
ADD target/users-mysql.jar users-mysql.jar
ENTRYPOINT ["java","-jar","users-mysql.jar"]



FROM maven:3.6.1-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package

FROM openjdk:8-alpine
COPY --from=build /workspace/target/target/users-mysql.jar users-mysql.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]