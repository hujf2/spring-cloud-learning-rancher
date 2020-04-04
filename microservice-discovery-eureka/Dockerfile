FROM openjdk:8u171-jdk-slim
VOLUME /tmp
MAINTAINER hujunfeng 419644560@qq.com
COPY target/*.jar /app.jar
#修改时区 centos
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/shanghai" > /etc/timezone

ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar -Xms512m -Xmx512m -Xmn256m  /app.jar
