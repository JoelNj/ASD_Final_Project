FROM amazoncorretto:23
WORKDIR /app
COPY build/libs/surveyApp-1.0.1.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "surveyApp-1.0.1.jar"]
