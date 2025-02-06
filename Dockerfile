# Stage 1: Build
FROM eclipse-temurin:21 AS builder
WORKDIR /app

# Copy all project files into the container
COPY . .
RUN ls -l
# Make sure the Maven wrapper is executable
RUN chmod +x ./mvnw

# Build the application using the Maven wrapper
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/MumbleApp-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 and set the entry point
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]