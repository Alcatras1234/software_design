# Use a Gradle base image to build the application
FROM gradle:8.0.2-jdk21 as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and configuration files
COPY gradle /app/gradle
COPY gradlew /app/
COPY build.gradle /app/
COPY settings.gradle /app/

COPY src /app/src/

RUN ./gradlew build -x test

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app/auth.jar

CMD ["sh", "-c", "java -jar auth.jar"]

