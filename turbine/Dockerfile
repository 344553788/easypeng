FROM java:8-jre-alpine
MAINTAINER Jeff <815899718@qq.com.com>

ADD build/libs/*.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8886
