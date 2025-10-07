# 1️⃣ Use Maven image to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2️⃣ Use a lightweight JDK runtime image
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/TechTriviaBackend-0.0.1-SNAPSHOT.jar app.jar

# 3️⃣ Expose the port Spring Boot runs on
EXPOSE 8080

# 4️⃣ Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]
