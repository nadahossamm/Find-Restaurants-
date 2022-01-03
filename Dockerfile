FROM openjdk:8-alpine
ADD target/users-mysql.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
