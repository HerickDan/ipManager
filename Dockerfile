FROM ubuntu:latest
LABEL authors="heric"

ENTRYPOINT ["top", "-b"]

FROM gradle:8-jdk21 AS build
COPY src /app/src
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
WORKDIR /app
RUN ./gradlew clean build

FROM amazoncorretto:21
COPY --from=build /app/build/libs/*.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]