FROM ubuntu:latest  AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 9080

COPY --from=build /target/my-assist-0.jar /app/my-assist.jar

ENTRYPOINT [ "java", "-jar", "/app/my-assist.jar"]