# Étape 1 : Construction de l'application Spring Boot
FROM maven:3.9.4-eclipse-temurin-21  AS build
WORKDIR /workspace
COPY pom.xml /workspace
COPY src workspace/src
RUN mvn clean package -DskipTests

# Étape 2 : Exécution de l'application Spring Boot
FROM eclipse-temurin:21-jre-slim
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
