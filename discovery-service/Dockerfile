# Build stage
FROM maven:3.8.3-openjdk-17 AS build
COPY src/ /home/app/src
COPY pom.xml /home/app/pom.xml
WORKDIR /home/app
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17
COPY --from=build /home/app/target/*.jar discovery-service.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/discovery-service.jar"]