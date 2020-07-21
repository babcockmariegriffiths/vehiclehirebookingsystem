FROM openjdk:8-jre-alpine

WORKDIR /swagger-vhbs

COPY target/lib/jetty-runner.jar /swagger-vhbs/jetty-runner.jar
COPY target/*.war /swagger-vhbs/server.war
COPY src/main/resources/openapi.yaml /swagger-vhbs/openapi.yaml
COPY inflector.yaml /swagger-vhbs/

EXPOSE 8080

CMD ["java", "-jar", "-DswaggerUrl=openapi.yaml", "/swagger-vhbs/jetty-runner.jar", "--log", "/var/log/yyyy_mm_dd-requests.log", "/swagger-vhbs/server.war"]
