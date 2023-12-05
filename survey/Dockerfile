# Use a base image with Java
FROM openjdk:17-oracle

# Optionally set a working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/survey-0.0.1-SNAPSHOT.jar /app/survey-0.0.1-SNAPSHOT.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/survey-0.0.1-SNAPSHOT.jar"]
