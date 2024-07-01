#
# Build stage
#
FROM maven:3.8.7-openjdk-18-slim AS builder

#AS build
COPY src /opt/app/src
COPY pom.xml /opt/app
WORKDIR /opt/app
RUN mvn clean install

#
# Package stage
#
FROM openjdk:20

#
#WORKDIR /opt/app
RUN mkdir -p /opt/app

#
## cp target/spring-boot-web.jar /opt/app/app.jar
COPY --from=builder /opt/app/target/projeto-modelo-api-0.0.1-SNAPSHOT.jar /opt/app/projeto-modelo-api.jar

#
## java -jar /opt/app/app.jar
## Normal
#ENTRYPOINT ["java","-jar","-Dspring.profiles.active=$ODP_ENVIRONMENT","/opt/app/projeto-modelo-api.jar"]
## Debug
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=$ODP_ENVIRONMENT","/opt/app/projeto-modelo-api.jar", "--debug"]