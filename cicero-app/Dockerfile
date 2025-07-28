FROM maven:3.8.6-eclipse-temurin-17-alpine AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17
WORKDIR /app
COPY --from=builder /app/target/cicero-app-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]