FROM java:8-jre-alpine
MAINTAINER Jeff <815899718@qq.com.com>

ADD build/libs/*.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=18886","-jar","/app.jar"]
EXPOSE 8886
EXPOSE 18886