# seckill
Java高并发秒杀API之业务分析与DAO层

# 可参考网友详细笔记
https://www.cnblogs.com/charles999/p/7115342.html

https://www.imooc.com/learn/587
Java高并发秒杀API之业务分析与DAO层

# 官网地址
1) logback配置：http://logback.qos.ch/manual/configuration.html
2) spring配置： http://docs.spring.io/spring/docs/
3) mybatis配置：http://mybatis.github.io/mybatis-3/zh/index.html

Maven命令创建WEB骨架项目
* mvn archetype:create -DgroupId=org.seckill -DartifactId=seckill -DarchetypeArtifactId=maven-archetype-webapp

注意:如果 maven版本是3.5以上用如下这个命令，其原因3.5版本以上丢弃掉create方式创建maven

* mvn archetype:generate -DgroupId=org.seckill -DartifactId=seckill -DarchetypeArtifactId=maven-archetype-webapp


修改servlet版本为3.1
web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
          http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1"
         metadata-complete="true">
  <!--修改servlet版本为3.1 -->
</web-app>

