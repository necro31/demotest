FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app
ADD gradle ./gradle
ADD src ./src
ADD build.gradle.kts ./
ADD settings.gradle.kts ./
RUN gradle clean build jar -x test

FROM bitnami/java:17
WORKDIR /app
COPY --from=builder /app/build/libs/demotest-1.0.0.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
