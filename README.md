# spring_maven
maven聚合项目+SpringMVC项目搭建

项目搭建说明：

以公司项目为例：

1、Maven多模块项目介绍，结构如下:



其中，admin和weixin为springmvc前端模块，内含controller层和相关页面。依赖core模块。core中主要放置service层及repository层代码。

2、创建maven多模块项目
2.1、首先创建maven多模块项目
create New Project——Maven——project





2.2、在项目下，new —— module——maven创建多模块。包含web部分
的admin和weixin用模板创建。core和parent无模板创建。


创建完成后项目如下：



3、添加模块之间的依赖

3.1修改pom文件

将parent模块作为整个项目maven管理的总依赖。parent模块pom文件修改如下：


说明：
dependencies即使在子项目中不写该依赖项，那么子项目仍然会从父项目中继承该依赖项（全部继承）
dependencyManagement里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖。如果不在子项目中声明依赖，是不会从父项目中继承下来				的；只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项，并且version和scope都读取自父pom;另外如果子项目中指定了版本号，那么会使用子项目中指定的jar版本。

project级的pom文件修改如下：


core模块的pom文件如下：


admin和weixin模块的pom文件如下：


4、此时HelloWorld即可运行，配置Tomcat略过。

5、配置SpingMVC。以admin为例。

5.1、配置web.xml,配置如下：

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
  <display-name>Archetype Created Web Application</display-name>

  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring-context.xml</param-value>
  </context-param>

  <!-- Filter -->
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <async-supported>true</async-supported>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value></param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
    <async-supported>true</async-supported>
  </servlet>
  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>

</web-app>

5.2、配置spring-context.xml，位置在resources下。

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
      http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
      http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <context:component-scan base-package="com.irelint.controller"/>
    <mvc:annotation-driven/>

</beans>

5.3、在admin/src/main   下新建JAVA文件夹。java右击Mark Directory as  Souce root。
在java文件下新建package  。包名为com.irelint.controller,新建IndexController.java,代码如下：

package com.irelint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cuishiying on 2017/2/24.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public Object index(){
        return "ok";
    }
}

此时即完成了项目的所有搭建。
后续会补充springMVC各种请求接口






