FROM maven:3.9.16-amazoncorretto-25-alpine AS build
COPY ../pom.xml /build/
WORKDIR /build/
RUN mvn dependency:go-offline
COPY ../src /build/src/
RUN mvn package -DskipTests

FROM amazoncorretto:25-alpine
ARG JAR_FILE=/build/target/*.jar
COPY --from=build $JAR_FILE /opt/notesmanager.jar
ENTRYPOINT ["java", "-jar", "/opt/notesmanager.jar"]