FROM maven:3.8-amazoncorretto-17
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
EXPOSE 1111
CMD ["mvn", "spring-boot:run"]