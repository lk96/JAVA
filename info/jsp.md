JSP基础语法

  一、 JSP简介
  
       JSP(Java Server Pages),其根本是一个简化的Servlet设计，它实现了在Java中使用HTML标签。
       JSP是一种动态网页技术标准，也是JavaEE的标准。 JSP和Servlet一样，是在服务器端执行的。
       JSP是在Servlet技术发展之后为了让开发者写html标签更方便而发展起来的技术，JSP实际上就是Servlet。
       但是，人们通常把Servlet作为Web应用中的控制组件来使用，只负责响应请求产生数据，并把数据通过转发技术带给jsp，
       而把jsp技术作为数据显示模板来使用。这样使程序结构更清晰，可读性和可维护性更高。
     2、常用动态网站开发技术
         JSP：Java平台，安全性高，适合开发大型的，企业级的，分布式的Web应用程序。如Hadoop，电子银行，12306等
         ASP.net：.Net平台，简单易学。但是安全性以及跨平台型差。
         PHP：简单，高效，成本低开发周期端，特别适合中小型企业的Web应用开发。（LAMP：Linux+Apache+MySQL+PHP）
 二、 路径
 
        1.绝对路径
        依靠自身就能唯一确定资源的路径，内容上以协议开头，如在HTTP请求中以http开头。

        2.相对路径
        必须依赖其他路径才能唯一确定资源的路径，内容上不以协议开头。

        3.资源路径构成
        访问路径+资源名称，资源名称是最后一个“/”后面的内容，其余是访问路径。

        4.WEB-INF路径
        放在WEB-INF目录下的资源只能通过程序转发访问，无法通过浏览器直接访问，比较安全。重定向执行时是将地址发给浏览器，
        由浏览器发出请求， 因此程序内部的重定向也无法直接访问WEB-INF目录下的资源。
        在WEB-INF目录下的资源内部只能采用相对于服务器的路径，不能采用相对于当前资源访问路径的路径，即只能采用如下路径形式：

        ${pageContext.request.contextPath}/xxx
        5.重定向路径
        所有的重定向只能采用相对于服务器的路径形式，因为重定向可以访问其他项目中的资源，路径的起点是服务器。
        根据地址栏地址的变化，HTML页面、JSP页面中的所有请求都可以看做重定向，所有的路径均必须采用相对于服务器的形式。

        6.转发路径
        所有的转发只能采用相对于项目的路径形式，因为转发只能访问同一项目内的资源。
        
        
三、JSP页面元素构成

         3.1、JSP指令：
             JSP指令(directive)是为JSP引擎二设计的，它们并不直接产生任何可见输出，而只是告诉引擎如何处理JSP页面中的其余部分。
             在JSP2.0规范中共定义了三个指令，基本语法格式为，<%@ 指令 属性名="值" %>
             ，如果一个指令有多个属性，这多个属性可以写在一个指令中，也可以分开写。
              page指令：page指令用于定义JSP页面的各种属性，无论指令出现在页面中的什么地方，它作用的都是整个JSP页面，
              为了保持程序的可读性和遵循良好的编程习惯，page指令通常放在整个JSP页面的起始位置，一个页面可以有多个page指令。

            <%@ page language="java" contentType="text/html,ISO-8859-1" import="java.util.*,java.sql.*,java.io.*" 
            session="true|flase" buffer="none|8kb|sizekb" autoFlush="true|false" info="一段字符串内容" 
            errorPage="relative_url" isErrorpage="true|false"%>
            1、language 指定JSP页面使用的脚本语言，默认值为java
            2、contentType 用来指定JSP页面的文件类型和所采用的编码方式， 默认值为“text/html,ISO-8859-1”
            3、import 通过该属性来引用脚本语言中使用到的类文件，导入多个类或包用逗号分隔。
               JSP引擎自动导入java.lang.*;java.servlet.*;javax.servlet.jsp.*;javax.servlet.http.*
            4、pageEncoding 指定JSP页面的编码方式， 默认值为“ISO-8859-1”
            5、session，用来说明是否创建session对象，默认为true
            6、buffer，用来指定out对象是否创建buffer缓冲区，并指定缓冲区大小。默认为8kb,none表示不创建缓冲区。
            7、autoFlush，缓冲区是否自动刷新，默认为true，如果为false，缓冲区满后不手动刷新会包异常。
            8、info，定义一个字符串常量，使用getServletInfo方法可以打印。
            9、errorPage，指定异常处理页。也可以在web.xml中使用<error-page>元素为整个WEB应用程序设置处理页面，
              其中的<exception-type>子元素指定异常类的完全限定名，<location>元素指定以"/"开头的错误处理页面的路径。
              如果设置了某个JSP页面的errorPage属性，那么在web.xml文件中这是的错误处理将不对该页面起作用。
               include指令：用于引入其他JSP页面，如果使用include指令引入了其他JSP页面，
               那么JSP引擎将把这两个JSP翻译成一个Servlet，
               所以include指令引入通常也成为静态引入。
               <%@ include file=“被包含组件的绝对URL或相对URL"%>
               被引入的文件必须遵循JSP语法。被引入的文件可以是任意扩展名，即使其扩展名是html，
               JSP引擎也会按照处理jsp页面的方式处理它里面的内容，
               为了见名知意，JSP规范建议使用.jspf(JSP fragments)作为静态引入文件的扩展名。
               由于使用include指明将会涉及到2个JSP页面，并会把JSO翻译成一个Servlet，
               所以这两个JSP页面的指令不能冲突(pageEncoding和导包除外)
               taglib指令：使用标签库定义显得自定义标签，在JSP页面中启用定制行为。
               <%@ taglib prefix="c"uri=""%>
          3.2、表达式：
                在JSP页面中执行的表达式 <%=表达式%>，注意表达式不以分号结束。例如，当前时间:<%= new java.util.Date() %>
          3.3、脚本片段：
                在JSP页面中插入多行java代码 <% Java代码 %>，JSP引擎在翻译JSP页面时，
                会将JSP脚本片段中的Java代码原封不动的放到Servlet的_jspServlet方法中，
                所以，<% %>中的Java代码必须严格遵循java语法。
          3.4、声明：
                在JSP页面中定义变量或者方法  <%! Java代码 %>，声明中的Java代码被翻译到_jspService方法的外面，属于类，
                所以可以声明成员变量并初始化，也可以声明方法或定义方法，同时还可以声明静态代码块。
                JSP隐式对象的作用范围仅限于Servlet的_jspService方法，所以在JSP声明中不能使用这些隐式对象。

                <%!

                private int globalVar = 0;
                public void jspInit()
                {
                    System.out.println("initializing jsp!");
                }
                %>
                <%!
                public void jspDestroy()
                {
                    System.out.println("destroying jsp!");
                }
                static 
                { 
                    System.out.println("loading Servlet!"); 
                }
                %>

          3.5、注释(3种方式)：
                 JSP脚本注释：即java注释 //单行 , /*多行 */
                 HTML注释：<!--html注释，且客户端可见-->
                 JSP注释：<%--JSP注释，客户端不可见--%>
                 
          3.6、静态内容：

                  <%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

                  <html>
                    <head>
                      <title>index.jsp page</title>
                    </head>
                    <body>
                      <h1>大家好</h1>
                      <hr>
                      <!-- 我是HTML注释，在客户端可见 -->
                      <%-- 我是JSP注释，在客户端不可见 --%>
                      <%! 
                         String s = "hello";  //声明了一个字符串变量
                         int add(int x,int y) //声明了一个返回整型的函数，实现两个整数的求和。
                         {
                            return x+y;
                         }
                      %>
                      <% 
                         //单行注释
                         /*多行注释*/
                         out.println("大家好");
                      %>
                      <br>
                      你好，<%=s %><br>
                      x+y=<%=add(10,5) %><br>    
                    </body>
                  </html>

四、JSP运行原理及生命周期：

          
           用户第一次请求Tomcat会将jsp文件编程成一个Servlet的java文件，并将java文件编译成class文件，加载到内存，
           生成文件在Tomcat的work目录的对应项目文件夹。如果jsp页面发生了修改，JSP引擎会对其进行重新编译并加载到内存，
           以方便用户请求。注意，用户第一次请求一个jsp页面时，首先被执行的方法是构造方法。
           _jspService()方法被调用来处理客户端的请求。对每一个请求，JSP引擎创建一个线程来处理该请求。
           如果有多个客户端同时请求该JSP文件，则JSP引擎会创建多个线程。每个客户端请求对应一个线程。
           以多线程方式执行可以大大降低对系统资源的需求，提高系统的并发量及响应时间。
           但也要主要多线程的编程带来的额同步问题，由于该Servlet始终驻于内存，所以响应是非常快的。
            JSP引擎在调用JSP对应的_jspServlet时，会传递或创建9个与web开发相关的对象共_jspServlet使用。
            JSP技术的设计者为便于开发人员在编写JSP页面是获得这些web对象的引用，特意定义了9个相应的变量，
            开发人员在JSP页面中通过这些变量就可以快速获得这9大对象的引用。
 
JSP 9个内置对象

      1、内置对象简介
           JSP内置对象是Web容器创建的一组对象，不使用new关键字就可以使用的内置对象。
           
      2、四种作用域范围
         application_SCOPE：作用于整个Web应用，多个用户之间共享。
         session_SCOPE:作用于整个Web应用，单个用户之间共享。
         request_SCOPE:作用于请求，转发间请求共享。
         page_SCOPE：作用于当前页面，当前页面可见。
      3、out对象
         缓冲区：Buffer，即内存中的一块区域用来保存临时数据
         out对象：是JspWriter类的实例，是向客户端发送文本常用的对象，是通过调用pageContext对象的getOut方法返回的，
         其作用和用法与ServletResponse.getWriter方法返回的PrintWriter对象非常相似。
         JSP页面中的out隐式对象的类型为JspWriter，JspWriter相当于一种带缓存功能的PrintWriter，
         设置JSP页面的page指令的buffer属性可以调整它的缓存大小，甚至关闭它的缓存。
         当缓冲区满足如下条件是才会写入Servlet引擎提供的缓冲区：设置page指令的buffer属性关闭了out对象的缓存功能 ；
         out对象的缓冲区已满。整个JSP页面结束。      
      <%
         out.println("aaa");
         response.getWriter().write("bbb");
      %>
      "bbb会比aaa先输出"
 


         常用方法：1、void println(); 向客户端打印字符串
                   2、void clear(); 清除缓冲区的内容，如果在flush之后调用会抛出异常。
                   3、void clearBuffer(); 清除缓冲区的内容，如果在flush之后调用不会抛出异常
                   4、void flush(); 将缓冲区内容输出到客户端
                   5、int getBufferSize(); 返回缓冲区以字节数的大小，如不设缓冲区则为0
                   6、int getRemaining(); 返回缓冲区还剩余多少可用
                   7、boolean isAutoFlush(); 返回缓冲区满是，是自动清空还是抛出异常
                   8、void close(); 关闭输出流

      4、request/response对象

          请求响应机制请参考本博客的Servlet部分。
           4.1、表单的两种提交方式：get与post
                get:以明文的方式通过URL提交数据，数据在URL中可以看到。提交的数据最多不超过2KB。
                安全性较低，但效率比post方式搞。适合提交数据量不大，安全性高的数据。比如：搜索、查询等功能
                post：将用户提交的信息封装在HTML header内。
                适合提交数据量大，安全性高的用户信息。比如：注册、修改、上传等功能。
           4.2、request对象
                客户端的请求信息被封装在request对象中，通过它才能了解到客户端的需求，然后做出响应。
                它是HttpServletRequest类的实例。request对象具有请求域，即完成客户端的请求之前，该对象一直有效。             
                //request常用方法：
                String getParameter();返回指定参数的参数值
                String[] getParameterValues();返回指定参数的所有值
                void setAttribute();存储此请求中的属性
                object getAttribute();返回指定属性的属性值
                String getContentType();得到请求体的MIME类型
                String getProtocol();返回请求用的协议及版本号
                String getServerName();返回接受请求的服务器主机名
                int getServerPort();返回服务器接受此请求的端口号
                String getCharacterEncoding();返回字符编码方式
                void setContentEncoding();设置请求的字符编码方式
                int getContentLength();返回请求体的长度（以字节数）
                String getRemoteAddr();返回发送此请求的客户端IP地址
                String getRealPath(String path);返回一个虚拟路径的真实路径或相对路径的绝对路径
                StringgetContextPath();返回上下文路径，即项目的根目录
                中文乱码问题：request.setCharacterEncoding("UTF-8");
                URL中中文乱码问题：Tomcat的/conf/server.xml 的添加<Connector URIEncoding="UTF-8">属性。
        4.3、response对象
                 response对象包含了响应客户请求的有关信息，但在JSP中很少直接用到它。它是HttpServletResponse类的实例。
                 response对象具有页面作用域，及访问一个页面时，该页面内的response对象只能对这次访问有效，
                 其他的response对象对当前页面无效。           
                //response对象的常用方法
                String getCharacterEncoding();返回响应用的是何种字符编码
                void setContentType();设置响应的MIME类型，一般为"text/html, charset=UTF-8"
                PrintWriter getWriter();返回可以向客户端输出字符的一个对象("注意比较：PrintWriter与内置out对象的区别，
                PrintWriter对象的其输出总是提前于内置out对象，或者在out中手动flush")
                sendRedirect(loaction);重新定向客户端的请求
                 请求重定向：是客户端行为，response。sendRedirect(),从本质上将等同于两次请求，
                 前一次的请求对象不会保存，地址栏的URL地址会改变。
                 请求转发：是服务器行为，request.getRequestDispatcher().forward();是一次请求，
                 转发后请求对象会保存，地址栏的URL地址不会改变。
      5、session对象
                  session表示客户端与服务器的一次会话，Web中的session指的是用户在浏览某个网站时，
                  从进入网站到浏览器关闭所经过的这段时间，也就是用户浏览这个网站所花费的时间。
                  在服务器的内存中，为不同的用户保存着不同的session。
                  session对象是一个JSP内置的对象。
                  session对象在第一个JSP页面被装载是自动创建，完成会话期管理。
                  从一个客户打开浏览器并连接到服务器开始，到客户关闭浏览器离开这个服务器结束，被称为一个会话。
                  当一个客户访问一个服务器时，肯能会在服务器的几个页面之间切换，
                  服务器应当通过某种办法知道这是一个客户，就需要session对象。
                  session对象是HttpSession类的实例。
                //session的常用方法
                        long getCreationTime();返回session创建时间
                        String getId();返回session创建时JSP引擎为它设的唯一ID号
                        Object setAttribute();使用指定名称将对象绑定到此会话
                        Object getAttribute();返回与此会话中的指定名称绑定在一起的对象，没有返回null
                        String[] getValueNames();返回一个包含此session中所有可用属性的数组
                        int getMaxInactiveInterval();返回两次强求间隔多长时间此session被取消（单位秒）
                        void setMaxInactiveInterval();设置session存活时间。
         session的生命周期：
              创建：当客户端第一次访问某个jsp或者Servlet时候，服务器会为当前会话创建一个SessionId，
              每次客户端向服务端发送请求时，都会将此SessionId携带过去，服务端会对此SessionId进行校验。
              活动： 某次会话当中通过超链接打开的新页面属于同一次会话。只要当前会话页面没有全部关闭，
              重新打开新的浏览器窗口访问同一项目资源时属于同一次会话。除非本次会话的所有页面都关闭后，
              在重新访问某个jsp或者Servlet将会创建新的会话(但此时原有会话还存在，这个就的SessionId仍然存在于服务端，
              只不过再也没有客户端会携带它然后教育服务端校验，直到该会话超时。)。
              销毁：有三种销毁方式
                    1、调用了session.invalidate()方法
                    2、Session过期（超时）可以在web.xml中配置Session超时时间<session-config><session-timeout>1单位是分钟
                    3、服务器重新启动
      6、application对象
             application对象实现了用户间数据的共享，可存放全局变量。
             application开始于服务器的启动，终止于服务器的关闭。
             在用户的前后连接或不同用户之间的连接中，可以对application对象的同一属性进行操作。
             在任何地方对application对象属性的操作，都将影响到其他用户对此的访问。
             服务器的启动和关闭决定了application对象的生命。
             application对象是ServletContext类的实例。     
            //application的常用方法
                void setAttribute();使用指定名称将对象绑定到此会话
                Object getAttribute();返回与此会话中的指定名称绑定在一起的对象，如果没有，返回null
                Enumeration getAttributeNames();返回所有可用属性名的枚举
                String getServerInfo();返回JSP(Servlet)引擎名及版本号
       7、page对象
             page对象就是指向当前jsp页面本身，有点像类中的this指针，它是java.lang.Object类的实例。常用方法就是Object类的成员方法。
       8、pageContext对象  
              pageContext对象是JSP技术中最重要的一个对象，它代表JSP页面的运行环境，
              这个对象不仅封装了对其他8个隐式对象的引用，其自身还是一个域对象，可以用来保存数据。
              并且，这个对象还封装了web开发中经常涉及到的一些常用操作，例如include，forward其他资源、检索其他域对象中的属性等。
              pageContext对象提供了对jsp页面内所有的对象及名字空间的访问。
              该对象可以访问到本页所在的Session，也可以取本页所在的application中的属性值。
              该对象相当也页面中所有功能的集大成者。该对象的本类名也叫pageContext。             
                //pageContext的常用方法
                JspWriter getOut();返回当前客户端响应被使用的out对象
                HttpSession getSession();返回当前页中的Session对象
                Object getPage();返回当前页的page对象
                ServletRequest getRequest();返回当前页的Request对象
                ServletResponse getResponse();返回当前页的Response对象
                void setAttribute();设置属性及属性值
                Object getAttribute();在指定范围内取属性的值
                int getAttributeScope();返回某属性的作用范围
                void forward();跳转到另一个页面，地址栏不变
                void include();包含另一个页面，
                PageContext.APPLICATION_SCOPE 代表各个域的常量
                PageContext.SESSION_SCOPE
                PageContext.REQUEST_SCOPE
                PageContext.PAGE_SCOPE
                findAttribute(); 查找各个域中的属性
        9、Config对象
              Config对象是在一个Servlet初始化时，JSP引擎向它传递信息用的，
              此信息包括Servlet初始化时所要用到的参数（通过属性名和属性值构成）
              以及服务器的有关信息（ 通过传递一个ServletContext对象）              
                  //Config的常用方法
                  ServletContext getServletContext();返回含有服务器信息的ServletContext对象
                  String getInitParameter();返回初始化参数的值
                  Enumeration getInitparameterNames();返回Servlet初始化所需所有参数的枚举
        10、Exception对象
                Exception对象是一个异常对象，当一个页面在运行过程中发生了异常，就产生这个对象。
                如果一个jsp页面要应用此对象，就必须报isErrorPage设为true，否则无法编译。它实际上是java.lang.Throwable的对象。
                页面要想在有异常时得到处理，就要指定异常处理页面<% page errorPage="exception.jsp"%>         
                    //exception的常用方法
                    String getMessage();返回描述异常的消息
                    String toString();返回关于异常的简短描述消息
                    void printStackTrace();显示异常及其栈轨迹
                    ThrowableFillInStackTrace();重写异常的执行栈轨迹
 
五、JSP动作

         1、JSP动作元素(action elements):动作元素为请求处理阶段提供信息。动作元素遵循XML元素的语法，
         有一个包含元素名的开始标签， 可以有属性、可选的内容、与开始标签匹配的结束标签。
            JSP标签也称之为JSP Action（JSP动作）元素，它用于在JSP页面中提供业务逻辑功能，
            避免在JSP页面中直接编写java代码，造成jsp页面难以维护。
         2、JSP动作元素包含五大类：
              1、与存储JavaBean有关的：<jsp:useBean>, <jsp:setProperty>, <jsp:getProperty>
              2、JSP1.2规范就有的6个基本动作元素：<jsp:include>, <jsp:forward>, 
              <jsp:param>, <jsp:plugn>, <jsp:params>, <jsp:fallback>
              3、JSP2.0新增加，主要与JSP Document有关的6个动作元素：<jsp:root>, 
              <jsp:declaration>, <jsp:scriptlet>, <jsp:exception>, <jsp:text>, <jsp:output>
              4、JSP2.0新增加，主要永磊动态生成XML元素标签的值，包括3个动作：<jsp:attribute>, <jsp:body>, <jsp:element>
              5、JSP2.0新增加，只要用在Tag File中：<jsp:invoke>, <jsp:dobody>
         3、JSP常用标签
             <jsp:include>:该标签用于把另外一个资源的输出内容插入进当前JSP页面的输出内容中，
             这种在JSP页面执行时的引入方式称之为动态引入。
             <jsp:include page="relativeURL | <%=expression%>" flush="true|false" />。
             flush属性指定在插入其他资源的输出内容时，是否先将当前JSP页面的已输出的内容刷新到客户端。
             <jsp:include>与include指令比较：<jsp:include>标签是动态引入， 
             <jsp:include>标签涉及到的2个JSP页面会被翻译成2个servlet，
             这2个servlet的内容在执行时进行合并。而include指令是静态引入，涉及到的2个JSP页面会被翻译成一个servlet，
             其内容是在源文件级别进行合并。不管是<jsp:include>标签，还是include指令，它们都会把两个JSP页面内容合并输出，
             所以这两个页面不要出现重复的HTML全局架构标签，否则输出给客户端的内容将会是一个格式混乱的HTML文档。
             但include指令要比<jsp:include>标签效率高些。可以从下面的表格中更直观的看到两者的区别   
             
             <jsp:forward>:该标签用于把请求转发给另外一个资源。
             <jsp:forward page="relativeURL | <%=expression%>" />.
             等同于request.getRequestDispatcher("/url").forward(request,response)。即执行服务器内部跳转操作。
             <jsp:param>:当使用<jsp:include>和<jsp:forward>标签引入或将请求转发给其它资源时，
             可以使用<jsp:param>标签向这个资源传递参数。
             <jsp:include page="relativeURL | <%=expression%>">
             <jsp:param name="parameterName" value="parameterValue|<%= expression %>"/>
             </jsp:include>
             可以使用多个<jsp:param>标签来传递多个参数。
         4、映射JSP
          
            映射JSP就是将一个JSP映射成其他任意形式的URL，在web.xml文件张配置

              <servlet>
                  <servlet-name>SimpleJspServlet</servlet-name>
                  <jsp-file>/jsp/simple.jsp</jsp-file>
                  <load-on-startup>1</load-on-startup >
              </servlet>
                  ……
              <servlet-mapping>
                  <servlet-name>SimpleJspServlet</servlet-name>
                  <url-pattern>/xxx/yyy.html</url-pattern>
              </servlet-mapping>

 

六、JavaBeans

       1、Javabean简介
              Javabeans就是符合某种特定规范的Java类。
              使用Javabeans的好处是解决代码重复编写，减少代码冗余，功能区分明确，提高了代码的可维护性。
       2、Javabean设计原则
               必须是共有类；
               必须包含一个无参的共有构造方法；
               所有属性必须私有；
               使用getter和setter访问器对属性访问封装。              

            public class Book {  //一个符合要求的Javabean类
                private String bookName;
                private String author;
                private double price;
                public Book() {
                }
                public String getBookName() {
                    return bookName;
                }
                public void setBookName(String bookName) {
                    this.bookName = bookName;
                }
                public String getAuthor() {
                    return author;
                }
                public void setAuthor(String author) {
                    this.author = author;
                }
                public double getPrice() {
                    return price;
                }
                public void setPrice(double price) {
                    this.price = price;
                }

       3、JSP中如何使用Javabean

              第一种方式：像使用普通java类一样，创建javabean实例。
              第二种方式：在JSP页面中通常使用jsp动作标签使用javabean。
       4、<jsp:useBeans>
              作用：在jsp页面中实例化或者在指定范围内使用javabean
              <jsp:useBean id="标识符" class="java类名" scope="作用范围"/> scope默认为page。
       5、<jsp:setProperty>
               作用：给已经实例化的Javabean对象的属性赋值，一共有四种形式：
               <jsp:setProterty name="Javabean实例名" property="*"/>（跟表单关联）
               <jsp:setProterty name="Javabean实例名" property="Javabean属性名"/>（跟表单关联）
               <jsp:setProterty name="Javabean实例名" property="Javabean属性名" value="BeanValue"/>（手工设置）
               <jsp:setProterty name="Javabean实例名" property="propertyName" param="request对象中的参数名"/>
               （跟request参数关联）通过url地址传递的参数
       6、<jsp:getProperty>
               作用：获取指定Javabean对象的属性值。
               <jsp:getProperty name="Javabean实例名" property="属性名"/>
       7、Javabean的四个作用域范围
                使用useBeans的scope属性可以用来指定javabean的作用范围。
                page：仅在当前页面有效
                request：可以通过request.getAttribute方法取得JavaBean对象
                session：可以通过session.getAttribute方法取得JavaBean对象
                application：可以通过application.getAttribute方法取得JavaBean对象
七、Model1架构模式

       1、Model1架构模式简介

                Model1应用了JavaWeb开发当中的两种技术，即JSP和JavaBean技术，所以Model1就是JSP+JavaBean模式。
                其中JSP需要独自完成响应用户的请求并将处理结果返回给用户，同时还需要完成流程的控制处理；
                而JavaBean进行辅助，如保存从数据库中查询出来的数据等。

                JavaBean 是一种使用Java语言编写的可重用组件。为写成JavaBean，类必须是具体的和公共的，并且具有无参数的构造器。
                JavaBean 通过提供符合一致性设计模式的公共方法将内部域的成员属性暴露给用户。
                用户可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以用Java代码创造的对象进行打包，
                并且其他的开发者可以通过内部的JSP页面、Servlet、其他JavaBean、Applet程序或者应用来使用这些对象。

                JavaBean可分为两种：一种是有用户界面（UI，User Interface）的JavaBean；
                还有一种是没有用户界面，主要负责处理事务（如数据运算、操纵数据库）的JavaBean。
                JSP通常访问的是后一种JavaBean。

       2、Model1的体系结构图

            ![model1图片](https://github.com/lk96/JAVA/blob/master/img/model1.jpg)

                下面对上图的Model1体系结构图进行分析。

                (1) 首先Web客户端向JSP页面发出request请求；

                (2) 在JSP页面取得请求所需的页面参数；

                (3) 通过JSP调用业务逻辑层的方法并返回结果；

                (4) 在JSP中完成网页页面的渲染；

                (5) 通过JSP向Web客户端返回处理结果。

                3、Model1架构模式的优缺点

                (1) 优点：架构简单，比较适合小型项目的开发。基本上使用JSP+持久层就可以完成一个小型项目的开发。

                (2) 缺点：JSP页面有控制页面显示的代码又有与后台业务逻辑交互的Java代码，职责不单一，页面负担很重，影响页面运行速度；
                而且不方便后期的维护。如果不加选择地随意运用Model 1，会导致JSP页面内被嵌入大量的脚本片段或Java代码，
                特别是当需要处理的请求量很大时，情况会更为糟糕。



      2.Model2架构模式

         1、Model2架构模式简介
 ![model2图片](https://github.com/lk96/JAVA/blob/master/img/model2.jpg)
 
                Model 2架构模式是一种把JSP与Servlet联合使用来实现动态内容服务的方法，所以Model2就是JSP+Servlet+JavaBean模式。
                它吸取了两种技术各自的突出优点，使用JSP生成表达层的内容，使用Servlet完成深层次的处理任务。
                在Model 2中，Servlet充当控制者的角色，负责管理对请求的处理，创建JSP页面所需的JavaBean和对象，
                同时根据用户的动作决定把哪个JSP页面传给用户。
                特别要注意，在JSP页面内没有处理逻辑，它仅负责检索原先由Servlet创建的对象或JavaBean，
                然后从Servlet中提取动态内容插入到静态模板中进行页面显示。
                所以简单来说，在Model 2中，JSP进行页面显示，JavaBean进行逻辑处理，Servlet完成逻辑控制。

         2、Model2的体系结构

             

                (1) 首先Web客户端向Servlet发出request请求；

                (2) 通过Servlet取得请求所需的表单数据；

                (3) Servlet向业务逻辑层调用业务逻辑方法并返回所需的数据；

                (4) Servlet再重定向转到JSP页面，在JSP页面完成页面渲染；

                (5) 通过JSP通过response向Web客户端返回处理结果。

         3、Model2架构模式的总结

                (1) JavaBean(Model)——模型层：主要职责是完成业务逻辑和保存数据的状态；

                (2) JSP(View)——视图层，主要职责是完成页面显示；

                (3) Servlet(Controller)——控制器，主要职责是获取表单数据、调用业务逻辑和完成页面的渲染。

          4、Model2架构模式的优缺点

                (1) 优点：清晰地分离了表达和内容，明确了角色的定义以及开发者与网页设计者的分工，适合大型项目的开发。

                (2) 缺点：分层过多，不适合小型项目的开发。

          5、Model1与Model2的比较

                Model1在一定程序上实现了MVC的设计理念，即JSP将控制层与表示层合二为一，JavaBean则为模型层。
                这样的话当然还是将控制层从JSP中单独划分出来比较好。

                Model2则是将控制层(Servlet)单独地划分出来了，专门负责业务流程的控制，响应页面的请求，
                创建所需的JavaBean实例，并将处理后的数据再返回给JSP。
                这样层次分明，不同开发人员的职责分工明确，所以项目越复杂，使用Model 2架构模型的好处就越大。



      3、三层架构模型

                将Model2中的数据访问部分再次抽离出来得到持久化逻辑层，可以得到经典的三层架构模型。
![三层图片](https://github.com/lk96/JAVA/blob/master/img/three.jpg)


         (1) 以上为非常经典的三层结构模型：

                表示层：JSP/Servlet

                业务逻辑层：业务规则

                持久化层：主要是包装持久化逻辑

                (2) 抽取出持久化层的好处：主要是为了持久化层的改变不会影响业务逻辑层，从而更好地划分职责。

                (3) 表示层、业务逻辑层、持久化层是自上而下的依赖关系，而且通常是单向依赖，最好依赖于抽象的东西。
            
 
八、JSP状态管理

         1、http协议的无状态性
              无状态是指，当浏览器发送请求该服务器的时候，服务器响应客户端请求。
              但是当同一个浏览器再次发送请求给服务器的时候，服务器并不知道它就是刚才那个浏览器。
              简单的说就是服务器不会记得你，所以就是无状态协议。
         2、保存用户状态的两大机制
              Cookie技术、Session技术
         3、Cookie简介
              Cookie：是Web服务器保存在客户端的一系列文本信息。
              典型应用：判定注册用户是否已经登录网站。
                        购物车的处理。
              Cookie的作用：
                          对特定对象的追踪
                          保存用户网页浏览记录与习惯
                          简化登录
               安全风险：容易泄露用户隐私信息。
         4、Cookie的创建与使用
              
         5、Session与Cookie的对比
                共同点：都是用来保存用户状态的；都会过期
                Session：在服务器端保存用户信息，保存的是Object类型，随会话的结束而将其存储的数据销毁，保存重要的信息。
                Cookie：在客户端保存用户信息，保存的是String类型，可以长期保存在客户端，保存不重要的用户信息。
