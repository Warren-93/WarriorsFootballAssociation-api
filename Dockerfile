FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY .. /app

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /WarriorsFootballAssociation-api/target/WarriorsFootballAssociation-api-0.0.1-SNAPSHOT.jar wfa.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","wfa.jar"]