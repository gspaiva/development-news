FROM openjdk:8
COPY target/*.jar /usr/local/service-server/app-server.jar
WORKDIR /usr/local/service-server
EXPOSE 8761
CMD  ["java","-jar", "app-server.jar"]