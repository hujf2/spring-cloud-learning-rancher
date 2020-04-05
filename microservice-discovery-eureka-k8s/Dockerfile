FROM openjdk:8u171-jdk-slim
VOLUME /tmp
MAINTAINER hujunfeng 419644560@qq.com
#ADD target/account-register-center-0.0.1-SNAPSHOT.jar app.jar
#ADD Reptile_mobile_web-0.0.1-SNAPSHOT.jar app.jar
ENV project spring-cloud-learning
ENV mod microservice-discovery-eureka
#ENV apppath /root/.jenkins/workspace/${project}/${mod}
#WORKDIR ${apppath}
#ENV apppath /root/.jenkins/workspace/spring-cloud-learning/microservice-discovery-eureka
#WORKDIR ${apppath}/
COPY target/microservice-discovery-eureka-0.0.1-SNAPSHOT.jar /microservice-discovery-eureka-0.0.1-SNAPSHOT.jar
#修改时区 centos
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/shanghai" > /etc/timezone

ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar -Xms512m -Xmx512m -Xmn256m  /microservice-discovery-eureka-0.0.1-SNAPSHOT.jar
