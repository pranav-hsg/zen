FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN mvn clean package -DskipTests
COPY api/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8081
EXPOSE 3306