FROM openjdk:17

COPY pom.xml ./
COPY .mvn /.mvn
COPY mvnw ./

RUN ./mvnw dependency:go-offline

COPY src ./src
CMD ["./mvnw", "spring-boot:run"]