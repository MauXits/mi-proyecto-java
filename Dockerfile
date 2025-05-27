FROM openjdk:17-jdk-slim
WORKDIR /app
COPY dist/LAB03.jar .
EXPOSE 8080
CMD ["java", "-jar", "LAB03.jar"]
