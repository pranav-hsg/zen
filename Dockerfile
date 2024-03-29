FROM maven:3.8.5-openjdk-17 AS build
COPY . .
COPY base/pom.xml .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /api/target/*.jar app.jar
EXPOSE 8081
EXPOSE 3306
ENTRYPOINT ["java", "-jar", "/app.jar"]
