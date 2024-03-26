FROM openjdk:17
WORKDIR /appContainer
COPY ./target/spring-docker.jar /appContainer/
EXPOSE 8083
CMD [ "java","-jar","jenkinsCICD.jar" ]