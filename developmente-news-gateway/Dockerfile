FROM openjdk:8
COPY target/*.jar /usr/local/service-gateway/app-gateway.jar
WORKDIR /usr/local/service-gateway
EXPOSE 8080
CMD  ["java","-jar", "app-gateway.jar"]