1、  为什么需要JavaEE

    我们编写的JSP代码中，由于大量的显示代码和业务逻辑混淆在一起，彼此嵌套，不利于程序的维护和扩展。当业务需求发生变化的时候，对于程序员和美工都是一个很重的负担。
    为了程序的易维护性和可扩展性，这就需要我们使用JavaEE技术来进行项目开发

2、  什么是JavaEE

    JavaEE是一个开发分布式企业级应用的规范和标准。

    Java语言的平台有3个版本：适用于小型设备和智能卡的JavaME（Java Platform Micro Edition，Java微型版）、适用于桌面系统的JavaSE（Java Platform Micro Edition，Java标准版）、适用于企业应用的JavaEE（Java Platform Enterprise Edition，Java企业版）。

3、  JavaEE包括的技术

    JavaEE应用程序是由组件构成的。J2EE组件是具有独立功能的单元，他们通过相关的类和文件组装成JavaEE应用程序，并与其他组件交互。

    JavaEE包括的技术有：Web Service、Struts、Hibernate、Spring、JSP、Servlet、JSF、EJB、JavaBean、JDBC、JNDI、XML、JavaSE。

4、  什么框架

    框架即Framework，我们可以把框架理解为某种应用的半成品，就是一组组件，供用户选用，完成用户自己的系统。简单地说就是使用别人准备好的组件，来实施自己的项目。

5、  JavaEE与框架的关系

    框架技术是在JavaEE的基础上形成的，而应用程序是在框架的基础上创建的。

![javaEE与框架关系](https://github.com/lk96/JAVA/blob/master/img//11.jpg)

 


6、  JavaEE的体系结构

    应用程序的三层结构如下：

    表示层：由用户界面和用户生成界面的代码组成。

    中间层：包含系统的业务和功能代码。

    数据层：负责完成存取数据库的数据和对数据进行封装。

    三层体系结构的优点：

    一个组件的更改不会影响其他两个组件。例如：如果用户需要更换数据库，那么只有数据层组件需要修改代码。同样，如果更改了用户界面设计，那么只有表示层组件需要修改。

    由于表示层和数据层相互独立，因而可以方便地扩充表示层，使系统具有良好的可扩展性。

    代码重复减少，因为在3个组件之间尽可能地共享代码。

    良好的分工与协作。这将使不同的小组能够独立地开发应用程序的不同部分，并充分发挥各自的长处和优势。

7、  JavaEE技术内容

    JavaEE技术体系结构可分为：表示层技术、中间层技术、数据层技术。JavaEE还涉及到系统集成的一些技术。

7.1、表示层技术

       HTML

       JavaScript

       Ajax

    Ajax是几种技术的整合。Ajax的主要功能是异步地向服务器端发送请求，处理数据或者根据返回的数据重新显示页面。

7.2、中间层技术

       JSP

       显示动态内容的服务器网页。

       Servlet

       接收客户端请求，并做出响应的Java程序。

       Servlet是中间层技术的重要组成部分，它控制着其他的组件。

       JSTL

       辅助JSP显示动态内容的标准标签库。

       JavaBean

       JavaEE的模型组件。

       中间层的框架技术

       Struts框架：Struts主要是扩展了Servlet。

7.3、数据层技术

       JDBC技术

       JDBC（Java Database Connectivity）：Java数据库连接。

       使用JDBC操作数据库中的表和数据。

       数据层框架技术

       数据层框架，Hibernate提供了以对象的形式操作关系型数据库数据的功能。

7.4、系统集成技术

    在一些大型项目中，整个应用程序被分成若干个模块，由不同的开发团队同步进行开发，有可能他们使用的技术也是各不相同的，在每个功能模块开发结束后，所要做的事情就是把这些零散的模块，整合成一个整体，这才是我们也是客户所要的东西，这时我们就要用到有关系统集成的技术（Web Service）。

JAX-WS技术

    JAX-WS（Java API for XML Web Service）是JavaEE平台的重要组成部分。

    JAX-WS简化了使用Java技术开发Web服务的工作。

    JNDI

    JNDI（Java Naming and Directory Interface，Java命名和目录接口）是一组在Java应用中访问命名和目录服务的API，命名服务把对象和名称联系在一起，并且可以通过名称找到相应的对象。

8、  HTTP（HyperText Transfer Protocol，超文本传输协议）协议

    HTTP是一个无状态协议，它基于客户端/服务器模型。HTTP客户端（如浏览器）需要与服务器建立一个连接，并将一则请求消息通过连接发送到HTTP服务器，以请求相应的资源。然后服务器返回带有请求资源的响应消息。当响应结束后，就断开连接，彼此并不保存连接信息。所以HTTP是无状态协议。

    HTTP使用端口发送和接收消息。端口是协议发送和接收数据的信道或机制。80端口是为HTTP开发的，主要用于在WWW（World Wide Web，万维网）服务上传输信息。浏览网页服务默认的端口号是80。

9、  使用MyEclipse提供的数据监控工具TCP/IP Monitor来进行数据监控。

    TCP/IP Monitor（TCP/IP 监控器）的配置步骤：

    Window（窗口）--->Preferences（首选项）--->Run Debug（运行/调式）--->TCP/IP Monitor（TCP/IP 监视器）

    注意：如果没有找到，则按以下路径查找：

    Window（窗口）--->Preferences（首选项）--->MyEclipse ---> Internet Tools（因特网工具）---> TCP/IP Monitor（TCP/IP 监视器）

    然后选中Show the TCP/IP Monitor view there is activity（显示TCP/IP监视器视图，用来查看什么时候有请求和响应）。

    单击“Add”按钮，弹出New Monitor窗口。

    Local monitoring Port：填写8088。本机监控端口，也就是Monitor实际监听的端口。

    Host name：填写localhost或127.0.0.1。欲监控的主机名称，监听对象的设置。

    Port：填写8080。欲监控的端口号，你想要监听的端口号，你的请求发送到Local monitoring Port后会转到这个端口。

    Type：选择HTTP。要监控的类型。

    Timeout：0 。

    单击确定按钮，然后单击Start（启动）按钮启动监视器。

    然后启动tomcat，在地址栏中输入：http://localhost:8088/项目名（或上下文路径）。在MyEclipse中会出现“TCP/IP Monitor”窗口，可以看到监听的数据了。

    可以单击窗口右上角的ValidateWS-I Message Log File图标（图标上有个勾）添加记录文件。

    下面对某一请求示例进行分析：

    客户端发送的消息为文本流，由以下内容组成：

    请求行：包括方法、统一资源标识符（URL）和HTTP协议版本。

    头信息：典型的请求消息类似于以下内容。

              GET /monitor/test.jsp?username=xinxin&userpassword=1234 HTTP/1.1

              Host: localhost:8080

              User-Agent: Mozilla/5.0(Windows;U;Window NT 5.1;zh-CN;)

              Accept: text/xml,application/xml, text/html; text/plain;

    第一行使用GET方法提交请求数据，并指定正在使用的是HTTP协议1.1版本。后续行包括头信息，User-Agent头指示客户端使用的浏览器类型是Mozilla，Accept头信息提供有关客户端可以接受的MIME类型列表。在头信息之后，客户端发送一个空白行，指示请求消息结束。请求消息由服务器进一步处理，并且生成相应的响应消息。

       下面是响应示例：

       HTTP/1.1 200 OK

       Server: JavaWebServer

       Last-modified: Tuesday, 21-Aug-07 11:12:10 GMT

       Content-length: 100

       Content-type: text/html

    第一行为状态行。状态行中的状态码200指示已成功处理请求，因此描述为“OK”，404是找不到被请求的网页时遇到的状态码。其他行是头信息，Server头指定服务器上使用的软件，Last-modified头指示被请求文件的最后修改日期，Content-length头指定文件的大小（以字节表示），Content-type头指定文档的MIME类型。例如，text/plain指示未格式化的文本文档。text/html指示格式化的Web文档。

10、 get和post发送方式

    post：post方式会将表单的内容通过http发送，在地址栏中看不到表单的提交信息，比较安全，而且使用post方式发送信息没有字符长度的限制。
    get方式：表单内容经过编码之后，通过URL发送，可以在地址栏中看到表单信息，不安全。使用get方式发送信息时有255个字符的限制。get请求的页面可以设置为书签或使用邮件发送，而post不可以。

