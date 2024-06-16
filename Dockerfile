FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app/.

EXPOSE 8080
ENTRYPOINT ["./mvnw", "spring-boot:run"]
