# Stage 1: Build
FROM eclipse-temurin:21 AS builder
WORKDIR /app

# Copy all project files into the container
COPY .. /app

# Make sure the Maven wrapper is executable
RUN chmod +x /app/mvnw
# Build the application using the Maven wrapper
RUN /app/mvnw clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/MumbleApp-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 and set the entry point
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]