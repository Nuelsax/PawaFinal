FROM openjdk:17
ADD  build/libs/pawaAssignment-0.0.1-SNAPSHOT.jar pawatask3.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pawatask3.jar"]
