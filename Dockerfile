# Use a base image appropriate for your application build stage
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY .. /app

# Build the Maven project
RUN mvn clean package -DskipTests

# Use a different base image for the production stage
FROM openjdk:17-jdk-alpine

# Copy the built JAR file from the build stage into the production image
COPY --from=build /app/target/WarriorsFootballAssociation-api-0.0.1-SNAPSHOT.jar wfa.jar

# Expose the port that your application listens on
EXPOSE 8080

# Define the command to run your application when the container starts
ENTRYPOINT ["java", "-jar", "wfa.jar"]
