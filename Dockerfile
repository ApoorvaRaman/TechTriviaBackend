# 1️⃣ Use official Java 17 image
FROM eclipse-temurin:17-jdk

# 2️⃣ Set working directory inside the container
WORKDIR /app

# 3️⃣ Copy project files
COPY . .

# 4️⃣ Build the Spring Boot JAR using Maven wrapper (skip tests)
RUN ./mvnw clean package -DskipTests

# 5️⃣ Expose the app port
EXPOSE 8080

# 6️⃣ Run the built JAR file
CMD ["java", "-jar", "target/TechTriviaBackend-0.0.1-SNAPSHOT.jar"]
