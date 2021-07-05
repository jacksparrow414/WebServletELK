# WebServletELK
传统Web Servlet项目接入Elasticsearch+Logstash+Kibana日志系统

## 简介
1. 此项目为传统的Web Servlet项目，并不是springboot项目.  
2. 本项目将Tomcat内部日志采用Log4j2输出(默认是JUL输出)，同时项目日志也采用Log4j2输出，并使用Log4j2的异步Appender将日志通过TCP的方式直接发送到Logstash中.  
3. 同时本项目也提供了将JUL日志转为Log4j2日志输出，在不改动现有代码的情况下的解决方案.  
4. 有关提到的Log4j2内容，请参考Log4j2官方文档.

## 项目须知
如有任何问题，请通过邮箱联系我或者提Issue :blush:

## 前提
- 最好具备Log4j2的一些配置知识，或者知道如何在Log4j2官方文档中找到自己需要的内容.
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
set JAVA_OPTS=-Djava.library.path=%CATALINA_HOME%\bin -Dlog4j2.garbagefreeThreadContextMap=true -Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector %JAVA_OPTS%
set CLASSPATH=%CATALINA_HOME%\log4j\*;%CATALINA_HOME%\lib\servlet-api.jar;%CLASSPATH%
```
- 关闭Tomcat，重新启动Tomcat,正常启动无报错
## 运行
在IDE里进行传统Web项目的Tomcat部署即可.有关如何在Eclipse,MyEclipse,IDEA中部署Tomcat web项目，这里不做说明，不清楚怎么做Google或者百度即可
## 写在最后
如果你想将以上配置放在springboot项目下运行，或者对配置有什么疑问，请参考[Log4j2相关文档](http://logging.apache.org/log4j/2.x/log4j-appserver/index.html)或查阅SpringBoot相关资料
