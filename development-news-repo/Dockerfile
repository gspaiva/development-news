FROM openjdk:8
COPY target/*.jar /usr/local/service-repo/app-repo.jar
WORKDIR /usr/local/service-repo
EXPOSE 8081
CMD  ["java","-jar", "-Dspring.profiles.active=${PROFILE}", "app-repo.jar"]