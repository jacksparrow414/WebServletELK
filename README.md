# WebServletELK
传统Web Servlet项目接入ELK日志系统

## 简介
此项目为传统的Web Servlet项目，并不是springboot项目。

## 项目须知
如有任何问题，请通过邮箱联系我或者提Issue :blush:

## 前提
- 本地需提前安装好Tomcat并能正常启动无报错，建议Tomcat8.5+
- 在Tomcat安装目录下新建一个文件夹，名字为log4j，文件夹里放入几个jar包：log4j-api-2.14.1.jar,log4j-appserver-2.14.1.jar,log4j-core-2.14.1.jar,log4j-web-2.14.1.jar,disruptor-3.4.4.jar
,同时在log4j文件夹内创建名为log4j2.xml文件，文件内容如下
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
    <Appenders>
        <!-- Console Appender -->
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d %level [%t] %logger %msg%n" />
        </Console>
    </Appenders>
    <Loggers>        
        <Root level="info">
            <AppenderRef ref="Console" />
        </Root>
    </Loggers>
</Configuration>
```
- 在Tomca安装目录下的bin文件夹内，根据当前操作系统新建setent.bat或者setenv.sh文件，Window下文件内容如下
```xml
set JAVA_OPTS=-Djava.library.path=%CATALINA_HOME%\bin -Dlog4j2.configurationFile=file:///D:/Tomcat/apache-tomcat-8.5.63/log4j/log4j2.xml -Dlog4j2.garbagefreeThreadContextMap=true -Dlog4j2.enableThreadlocals=true -Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector %JAVA_OPTS%
set CLASSPATH=%CATALINA_HOME%\log4j\*
```
- 启动Tomcat,正常启动无报错
## 运行
在IDE里进行传统Web项目的Tomcat部署即可
