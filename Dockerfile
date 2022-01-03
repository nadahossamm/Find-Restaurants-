FROM openjdk:8-alpine
ADD target/users-mysql.jar users-mysql.jar
ENTRYPOINT ["java","-jar","users-mysql.jar"]
