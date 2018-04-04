
一、基础篇
  1.面向对象的三大特性
      
      继承、封装、多态
      
  什么是继承？
      
          ①继承是面向对象程序设计能够提高软件开发效率的重要原因之一。
          ②继承是具有传递性的，就像现实中孙子不仅长得像爸爸而且还像他爷爷。
          ③继承来的属性和方法是隐式的，也就是在本类里面是看不见的。
          ④一个类只能有一个父类，也就是类只能是单继承。
          ⑤一个接口可以有多个父类，也就是接口可以是多继承。
          实际项目开发中，一个类继承于另一个类，那么前者就是后者的子类，反则反之。

什么是封装？
    
          对象数据和操作该对象的指令都是对象自身的一部分，能够实现尽可能对外部隐藏数据。
          实际项目开发中，使用封装最多的就是实体类，常常和JavaBean（类必须是具体的和公共的，并且具有无参数的构造器）一起使用。
          那么，实体类有那些东西呢？
          答：私有的成员变量、无参数的构造器、有参数的构造器、setter和getters方法、重写tostring方法、重写hashCode和equals方法。

什么是多态？
    
          ①多态就是对象拥有多种形态：引用多态和方法多态。
          ②引用多态：父类的引用可以指向本类对象、父类的引用可以指向子类的对象。
          ③方法多态：创建本类对象时，调用的方法为本类的方法；创建子类对象时，调用的方法为子类重写的方法或者继承的方法。
          ④存在多态的必要条件：继承、重写。
          ⑤多态的作用是消除类型之间的耦合关系。
          在实际项目开发中，A类继承B类，如果在A类中不重写B类的方法的时候，输出的仍旧是B类方法里面的信息（B b=new A()）；
          如果在A类中重写B类的方法的时候，输出的是A类方法里面的信息（B b=new A()）。
          2.Java集合框架树

java集合框架成员
![集合框架图片](https://github.com/lk96/JAVA/blob/master/img/java1.png)

         Collection接口：它是Java集合框架的一个根接口，也是List、Set和Queue接口的父接口。同时它定义了可用于操作List、Set和Queue的方法—增删改查。
          Map接口：它提供了一种映射关系，其中的元素是以键值对（key-value）的形式存储的。Map接口有一个重要的实现类HashMap。
          ①在Map接口中的键值对是以Entry类型的对象实例形式存在。
          ②在Map接口中键值（Key值）是不可以重复的，value值却可以重复，也就是存在多对一的关系。
          ③在Map接口中提供了分别返回Key值的集合、value值的集合以及Entry集合的方法。
          ④Map支持泛型，同时Key值和value值都是可以为null的。
          ⑤在HashMap中的Entry对象是无序排序的，这点特性和List接口是相反的。
          ⑥在HashMap中有且只能有一个Key值为null的映射。（注：key值是不能重复的）

          List接口：List接口有一个重要的实现类ArrayList（数组序列）。
          ①List是元素有序并且可以重复的集合。
          ②List可以精确的控制每个元素的插入位置，或删除某个元素的位置。

          Comparator接口：临时的比较规则。如果某一个类要实现这个接口，那必然要实现它的Compare()方法。

          Comparable接口：默认的比较规则。当实现了这个接口，则表示这个类的实例可以比较大小，
          可以进行自然排序。如果某一个类要实现这个接口，那必然要实现它的CompareTo()方法。

3.Java中的IO流
  字节流：

          //一个字节一个字节的读写
          FileInputStream in=new FileInputStream("源文件");
          FileOutputStream out=new FileOutputStream("目标文件");
          ......
          in.close();
          out.close();
          首先要记住，一旦使用了IO流最后一定要记得关闭，这是常识。

          //利用缓冲区，高效的读取字节
          BufferedInputStream in=new BufferedInputStream(new FileInputStream("源文件");
          BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("目标文件");
          ......
          in.close();
          out.close();
  字符流：

          InputStreamReader isr=new InputStreamReader(new FileInputStream("源文件路径"),"设置编码");
          OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("目标文件路径"),"设置编码");
          ......
          osw.close();
          isr.close();
          也可以这样写：

          FileReader fr=new FileReader("源文件路径");
          FileWriter fw=new FileWriter("目标文件路径");
          ......
          fr.close();
          fw.close();

          //利用缓冲区，高效的读取字符
          BufferedReader br=new BufferedReader(new FileReade("源文件路径");
          PrintWriter pw=new PrintWriter("目标文件路径");
          ......
          br.close();
          pw.close();
  序列化和反序列化：


          //对象的序列化
          ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
          这里的file指的是String file="文件在项目中的路径";

          //对象的反序列化
          ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
4 Java的Socket通信（多线程）

![Socket图片](https://github.com/lk96/JAVA/blob/master/img/java2.png)
 
       思路：
          ①首先创建服务器端Socket，指定并侦听某一个端口，然后循环监听开始等待客户端的连接….
          ②创建客户端socket，指定服务器地址和端口，然后获取输出流，向服务器端发送请求，并关闭socket输出流。
          ③服务端接收到客户端的请求后，创建新线程并启动。
          ④创建线程处理类，执行线程操作，获取输入流，服务端读取客户端用户详情，关闭资源。
          ⑤执行线程操作，获取输出流，响应客户端请求，客户端接受到服务端的响应，关闭资源。

          简单点讲，就相当于我跟你说话（客户端→服务端），你收到我说的话（服务端→线程处理类），大脑进行思考后（线程处理类），做出回答我的话（线程处理类→客户端）。

5.关系型数据库

       数据库的三范式：
           
         ①字段不可分。
         ②有主键，非主键字段依赖主键。
         ③非主键字段不能互相依赖。

T-SQL：
![sql图片](https://github.com/lk96/JAVA/blob/master/img/java3.png)
    
        在整个数据库中，查询操作占据增删改查的80%，而说到查询，T-SQL语句自然不能少。如图上示。

  增：
   
      ①插入单行
        insert into <表名> (列名) values (列值)
        ②将现有的表数据添加到一个已有表

        insert into <已有的新表> (列名) select <源表列名> from <源表名>
        ③直接拿现有表数据创建一个新表并填充

        select <新建表列名> into <新建表名> from <源表名>
  删：
       
         ①删除满足条件的行
        delete from <表名> where <删除条件>
         ②删除整个表

        truncate table <表名>
        注：删除表的所有行，但表的结构、列、约束、索引等不会被删除；不能用语有外建约束引用的表。

  改：
    ①更新

        update <表名> set <列名=更新值> where <更新条件>
  子查询：

        SELECT * FROM t1 WHERE column1 = (SELECT column1 FROM t2);
        其中：
        ①SELECT * FROM t1 …称为外查询。
        ②SELECT column1 FROM t2 称为子查询。
        所以，我们就说子查询是嵌套在外查询内部的。而事实上它也有可能在子查询内部再嵌套一个或者多个子查询。这里要注意，子查询必须出现在圆括号之间哦。  
二、Web篇

![生命周期图片](https://github.com/lk96/JAVA/blob/master/img/java22.png)
       
       思路：当用户使用客户端浏览器向服务器发送一个请求访问index.jsp页面，当服务器接收到客户的请求之后，开始判断用户所访问的这个资源是否是第一次访问？
        ①如果是第一次请求，那么Tomcat的JSP引擎就把这个JSP文件转换成一个Servlet（一个Servlet从本质上而言也是一个Java类）
        ，既然是一个Java类就需要通过编译，生成相应的字节码文件，然后执行jspInit这个初始化方法。再生成JSP页面的字节码文件，转到③。
        ②直接访问所生成的JSP页面的字节码文件，转到③。
        ③最后解析执行这个Java类当中的jspService方法，这个方法就是专门用来处理用户的请求。
JSP九大内置对象：
![内置对象图片](https://github.com/lk96/JAVA/blob/master/img/java4.png)

        out对象：它是JspWriter类的实例，是向客户端输出内容常用的对象。
        request对象：它表示客户端的一次请求，这个请求里面的信息是被封装在request对象中的。
        同时它也是HttpServletRequest类的实例，并且具有请求域，也就是在完成客户端的请求之前，该对象是一直有效的。
      常用方法：
        request.setCharacterEncoding("UTF-8");//设置编码，解决中文乱码问题。
        request.setAttribute("","");//前者为需要设置的属性，后者为需要的值。
        request.getAttribute();
        request.getRequestDispatcher("index.jsp").forward(request, response);//请求转发到index.jsp页面，该请求对象是一直有效的。
        response对象：它包含了响应客户请求的相关信息，它也是HttpServletResponse类的实例。
        和request一样，它具有页面的作用域，也就是在访问一个页面的时候，该页面的response对象只对这次访问有效，往后执行是不存在、无效的。
      常用方法：
        response.setContentType("text/html","charset="utf-8");//设置响应的MIMI类型。
        response.sendRedirect("index.jsp");//请求重定向，如果存在多次重定向，那么对象数据是不会保存下来的，即为null。
        请求转发和请求重定向的区别分析：

        请求重定向：客户端行为，response.sendRedirect()，从本质上讲等同于两次请求，前一次的请求对象不会保存，地址栏的URL地址会改变。
        请求转发：服务器行为，request.getRequestDispatcher().forward(req, resp);是一次请求，转发后请求对象会保存，地址栏的URL地址不会改变。

        session对象：当我们第一次访问页面的时候，session对象就会被自动装载和创建。它是HttpSession类的实例对象。
        什么是会话？为什么要用session对象？

        会话：当一个客户端打开浏览器连接到服务器开始，到客户端关闭浏览器服务器结束这个过程，我们称为一个会话。
        在实际情况下，客户在访问服务器的过程中，避免不了会在服务器的几个页面之间切换，
        这时候服务端有必要知道当前操作的客户是不是操作前几个页面的客户，也就是必须要清楚知道是否同一个人在进行操作
        。所以就引入了session对象这个概念。

        application对象：它实现了用户间数据的共享，可以存放全局变量，它是ServletContext类的实例。
        它的生命周期开始于服务器的启动，终止于服务器的关闭。

    注：
       	①在用户的前后连接或不同用户之间的连接中，可以对application对象的同一属性进行操作。
        ②在任何地方对application对象属性的操作，都将影响到其他用户对此的访问。

 	JSP的指令和动作：
        ①三个编译指令：page、include、taglib。
        ②七个动作指令：jsp:forward、jsp:param、jsp:include、jsp:plugin、jsp:useBean、jsp:setProperty、jsp:getPProperty。

JSP指令：

![JSP指令图片](https://github.com/lk96/JAVA/blob/master/img/java5.png)
![include指令与include动作的区别图片](https://github.com/lk96/JAVA/blob/master/img/java6.png)
![session的生命周期图片](https://github.com/lk96/JAVA/blob/master/img/java7.png)
        
  	Session生命周期的“活动”思路：
        ①某次会话当中通过超链接打开的新页面属于同一次会话。
        ②只有当前会话页面没有全部关闭，重新打开新的浏览器窗口访问同一项目资源时属于同一次会话。
        ③除非本次会话的所有页面都关闭后再重新访问某个Jsp或者Servlet将会创建新的会话。
        注：
        注意原有会话是还存在的，只是这个旧的SessionId仍然存在于服务端，只不过再也没有客户端会携带它然后交予服务端校验。
![Session与Cookie的对比图片](https://github.com/lk96/JAVA/blob/master/img/java8.png)
![过滤器的工作原理图片](https://github.com/lk96/JAVA/blob/master/img/java9.png)
![过滤器的生命周期图片](https://github.com/lk96/JAVA/blob/master/img/java10.png)
        
        注：
        ①当Web容器启动的时候，过滤器就已经加载并启动了。
        ②实例化只会实例化一次，也就是说在Web容器中只会使用一次。

![ 过滤器的分类图片](https://github.com/lk96/JAVA/blob/master/img/java11.png)
![Servlet生命周期图片](https://github.com/lk96/JAVA/blob/master/img/java12.png)
        
        思路:
        ①首先判断Servlet实例是否存在，如果存在则跳入第③步。
        ②初始化阶段，init初始化方法是在创建实例之后完成的。
        ③响应阶段，响应客户端的请求，调用service()方法。由service()方法根据提交方式选择性执行doGet()方法或者doPost()方法。
        ④终止阶段，调用Destroy()方法销毁，服务器关闭。

![Tomcat容器等级图片](https://github.com/lk96/JAVA/blob/master/img/java13.png)
    
Web监听器
![ web监听器图片](https://github.com/lk96/JAVA/blob/master/img/java14.png)
    
        Web监听器是有Servlet规范定义的一种特殊类，它可以监听客户端的请求和服务端的操作，同时它还可以监听，包括ServletContext、HttpSession、ServletRequest等对象。

![Web监听器的启动顺序图片](https://github.com/lk96/JAVA/blob/master/img/java15.png)
  
  
监听器的分类

    HttpSession的事件监听器

![HttpSession的事件监听器图片](https://github.com/lk96/JAVA/blob/master/img/java16.png)

  
    ServletContext的事件监听器

![ServletContext的事件监听器图片](https://github.com/lk96/JAVA/blob/master/img/java17.png)
  
  
     ServletRequest的事件监听器

![ServletRequest的事件监听器图片](https://github.com/lk96/JAVA/blob/master/img/java18.png)
        
          注：
          这三个监听事件，分别实现对应的接口，也就是图示的1..N。既然实现了接口，即必然要实现其对应的方法，如图所示。主要用途也如图所示。

 绑定到HttpSession域中的对象状态的事件监听器

 ![绑定到HttpSession域中的对象状态的事件监听器图片](https://github.com/lk96/JAVA/blob/master/img/java19.png)
       
         注：
          为什么要用session钝化？
          首先，正常情况下，我们的session是存放在服务器的session当中的，但是如果我们的用户很多的时候，仍然把session存放在服务器里，这时服务器的开销是很大的，会直接影响我们Web应用的使用。所以就需要使用到session钝化机制，它的本质就是将服务器未使用到的session对象暂时序列化到系统文件当中，当要使用的时候再反序列化到服务器内存当中。
 Model1和Model2
![Model1模型图片](https://github.com/lk96/JAVA/blob/master/img/java20.png)
      
          注：
          Model1是最早的能体现分层思想的一种开发模式，简单来说Model1就是一种Jsp+JavaBean的一种开发模式。
          缺点：可维护性和可扩展性是比较差的。

![Model2模型图片](https://github.com/lk96/JAVA/blob/master/img/java21.png)
   
          思路：
          ①首先由Jsp页面向Servlet提交一个请求。
          ②然后在我们的控制层Servlet实例化一个模型层的对象或者调用模型层的一些功能。
          ③然后由模型层来访问读取我们的数据库层。
          ④当得到读取到结果后，再将结果返回到我们的控制层。
          ⑤控制层得到这个结果后，会根据这个结果给用户展示不同的Jsp页面。

三、框架篇

    框架基础
         反射：反射是Java开发的一类动态相关机制。因为本身Java语言并不是一款动态语言，如果我们想要得到程序动态的效果，因此便引入了反射机制这一概念。

          怎么表达反射？
![反射图片](https://github.com/lk96/JAVA/blob/master/img/java35.png)

          能用反射做什么？
          PS：某面试题：Java中创建实例化对象有哪些方式？
          ①最常见的创建对象方法，使用new语句创建一个对象。
          ②通过工厂方法返回对象，例:String s =String.valueOf()。（工厂方法涉及到框架）
          ③动用反射机制创建实例化对象，Class类的三种方法或者通过类类型的newInstance()实例方法。
          ④调用对象的clone()方法。（俗称克隆方法）
          ⑤通过I/O留的反序列化手段，调用ObjectInputStream对象的readObject()方法。

      注解：日常开发中，注解的使用简化了不少代码，同时也减少了程序员的日常工作量。

      Java注解可以细分为JDK注解和第三方注解。其具体使用方法，可以点开链接看哦。


![注解图片](https://github.com/lk96/JAVA/blob/master/img/java23.png)
     
     ORM
      认识Hibernate和Mybatis之前，必然要先了解一下什么是ORM？

      ORM是三个单词的缩写：Object/Relationship Mapping。翻译过来就是“对象/关系映射”。

      为什么要有ORM？
      在用面向对象思想编写应用程序的时候，最终都是把对象的信息保存在关系型数据库中，这样我们就需要编写很多与底层数据库相关的SQL语句。显然这样是很不便捷的，ORM框架技术就可以解决这些繁琐的问题。

      ORM存在的意义？
      彻底抛弃书写SQL语句的思想，完全使用面向对象的思想开发。

      为什么要抛弃程序中书写SQL语句的思想？
      ①不同的数据库使用的SQL语法不同，例：同样一段SQL脚本，能在T-SQL中运行，但不一定能保证可以在PL-SQL中运行。
      ②同样的功能在不同的数据库有不同的实现方式，例：分页SQL。
      ③程序过分依赖SQL，对程序的移植、扩展和维护带来很大的麻烦。

Hibernate框架
      
      Hibernate是Java领域内的一款开源的ORM框架技术。
      Hibernate的机制原理：
      ①Hibernate对JDBC进行非常轻量级的封装。
      （从本质上而言，最终Hibernate还是通过JDBC来进行对数据库的操作，只不过在JDBC的基础上进行了一定的封装）
      ②与EBJ（本身是JavaEE的规范，重量级的ORM框架技术）不同，Hibernate属于轻量级的ORM框架技术。
      ③Hibernate介于数据库层和业务逻辑层之间，起到持久化层的作用。

 HQL数据查询基础
     
      检索对象——from子句
      选择——select子句
      限制——where子句
      排序——order by子句

      HQL和SQL语句不同，HQL中from子句是必须的，可以没有select子句。

 Hibernate的常用属性：

      cascade：设置级联关系。
      inverse：设置由哪一方维护关联关系。

      例：下面的这段代码集合了常用属性以及表与表之间的多对一和一对多关系。
      <hibernate-mapping>
          <class name="" table="">
              <id name="id" type="java.lang.Long">
                  <column name="ID" />
                  <generator class="increment" />
              </id>
              <many-to-one name="" class=""
                  fetch="">
                  <column name="" />
              </many-to-one>
              ......
              <set name="" inverse="true"  cascade="all" lazy="false">
                  <key>
                      <column name="" />
                  </key>
                  <one-to-many class="" />
              </set>
          </class>
      </hibernate-mapping>
Struts2框架
      
      Struts是流行和成熟的基于MVC设计模式的Web应用程序框架。
      struts2的工作原理及文件结构
      Struts2动态方法的调用：
![Struts2动态方法图片](https://github.com/lk96/JAVA/blob/master/img/java24.png)
     
     例:
      ①指定method属性的方法。
      <action name="" method="" class="">
      <result>/index.jsp</result>
      </action>
      ②感叹号的方式。
      <action name="" class="">
      <result>/index.jsp</result>
      </action>
      <constant name="structs.enable.DynamicMethodInvocation" value="true"></constant>
      ③通配符的方式。
      <action name="_*" method="{1}" class="">
      <result>/index.jsp</result>
      <result>/{1}.jsp</result>
      </action>
      在使用通配符方式的时候，如果要使用多个method的话，可以再在method="{1}{2}..."里面这样添加，同时需要修改name=""里面的名字+后缀_*_*...,还要配置所需要的<result>/{}.jsp</result>标签

      Struts2访问servlet api：
![Struts2访问servlet图片](https://github.com/lk96/JAVA/blob/master/img/java25.png)
      Struts2拦截器工作原理：
![Struts2拦截器工作图片](https://github.com/lk96/JAVA/blob/master/img/java26.png)
      
      思路：
      当Struts在执行一个action的时候，会在action执行之前去执行一些拦截器，如果有多个拦截器会依次进行执行。
      ①首先执行拦截器一，执行拦截器一的处理方法并做一些处理操作。
      ②如果还有其它的拦截器，将执行拦截器二、拦截器三…进行拦截。
      ③当所有的拦截器都执行之后，将执行action操作，并调用action中的业务处理方法进行业务的处理。
      ④调用完之后，会返回一个字符串结果，也就是Result结果集。然后进行视图的匹配。
      ⑤再将前面执行的拦截器进行反向的再执行一次，最终响应到客户端。

 Spring框架
     
      Spring是一个轻量级的控制反转（IOC）和面向切面（AOP）的容器框架和开源框架。
      Spring框架的好处：
      ①从大小和开销两个方面而言Spring都是轻量级的。
      ②通过控制反转的技术达到松耦合的目的。
      ③提供了面向切面编程的丰富支持，允许通过分离应用的业务逻辑和系统级服务进行内聚性的开发。
      ④包含并管理应用对象的配置和生命周期，从这个意义上讲它是一种容器。
      ⑤将简单的组件配置、组合成为复杂的应用，从这个意义上讲它是一种框架。

      什么是Spring的IOC？
![IOC图片](https://github.com/lk96/JAVA/blob/master/img/java27.png)
      
      思路：
      ①当业务的对象进入了Spring的容器。
      （Your Business Objects）→（The Spring Container）
      ②然后通过配置的原数据来生产出符合系统需要的对象。
      （Configuration Metadata）→（The Spring Container）→（Fully Configured system）
      ③当要使用这些对象的时候去Spring容器里面直接拿出来用就可以了。

      什么是Spring的AOP？
      AOP：通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。
      主要功能有：日志记录、性能统计、安全控制、事务处理、异常处理等。

      注：
      预编译方式：AspectJ。
      动态代理方式：JDK动态代理和CGLib动态代理。（也就是SpringAOP和JbossAOP）

      Spring的AOP用途：
      ①提供了声明式的的企业服务，特别是EJB的替代服务的声明。
      ②允许用户定义自己的方法，以完成OOP和AOP的互补使用。

Spring的事务管理

      Spring的事务管理高层抽象主要包括3个接口：

![Spring事务管理三个接口图片](https://github.com/lk96/JAVA/blob/master/img/java28.png)

      TransactionDefinition定义事务传播行为（7种）:
![TransactionDefinition定义事务传播行为t图片](https://github.com/lk96/JAVA/blob/master/img/java29.png)
Spring MVC框架
      
      Spring MVC是一种前端控制器的实现形式，它的基本概念分为静态概念 和 动态概念。
      静态概念：如图下示。DispatcherServlet就是Spring MVC的前端控制器。
      思路：
      ①当浏览器端用户的请求通过DispatcherServlet进行了分发，到达Cotroller层。
      ②到达Cotroller层之后，便生产出我们所需要的业务数据Model。
      ③然后Model层再通过DispatcherServlet进行传递给我们的View层。
      ④最后完成了最终的页面呈现。

      总结：MVC将业务逻辑和页面实现了分离，其核心就是通过DispatcherServlet实现的。

![mvct图片](https://github.com/lk96/JAVA/blob/master/img/java30.png)

      动态概念：如图下示。


![Spring MVC图片](https://github.com/lk96/JAVA/blob/master/img/java31.png)
     
     思路：
      ①当浏览器的请求Request到达DispatcherServlet。（因为DispatcherServlet也是一个Servlet，所有的Request能够被它拦截到）
      ②然后DispatcherServlet会搜索寻找到一个Mapping，也就是HandlerMaping，并将其功能代理给了HandlerMaping。
      ③然后HandlerMaping根据本身的配置，找到需要用到的Controller和HandlerInterceptor。
      ④然后把Controller和HandlerInterceptor制成一个可执行的链条，也就是Handler/HandlerAdapter的适配器。
      ⑤Handler/HandlerAdapter的适配器将信息返回给了DispatcherServlet，DispatcherServlet便开始调用这个一般化的处理器Handler/HandlerAdapter。
      ⑥Controller的目的就是生成ModelAndView模型，并且返还给DispatcherServlet。
      ⑦DispatcherServlet是不会管理视图显示的，所以它就调用ViewResolver视图解析器并通过该方法返回到View对象。（ViewResolver的作用是告诉DispatcherServlet哪个视图是用来解析当前这种场景的）
      ⑧然后ModelAndView将模型数据传递到View，完成了页面呈现。

      Spring MVC拦截器工作流程：
![Spring MVC拦截器工作流程图片](https://github.com/lk96/JAVA/blob/master/img/java32.png)

 Mybatis框架
      
      Mybatis和Hibernate一样，是一款开源的ORM框架的技术。
      Mybatis的机制原理：
      ①Mybatis支持普通的SQL查询、存储过程和高级映射的持久层框架。
      ②Mybatis将大量的SQL语句从程序里面剖离出来，配置在配置文件中，实现SQL的灵活配置。

      OGNL表达式：

![Mybatis中的OGNL表达式图片](https://github.com/lk96/JAVA/blob/master/img/java33.png)
     
![Mybatis中的OGNL表达式图片](https://github.com/lk96/JAVA/blob/master/img/java34.png)
   
      Mybatis框架和Hibernate框架比较：
      ①“全自动化”的Hibernate对数据库结构提供了完整的封装和全套映射机制。
      ②“半自动化”的Mybatis提供的ORM机制，对业务逻辑实现人员而言，面对的是纯粹的Java对象。
      ③Hibernate会自动生成SQL语句，而MyBatis不会在运行期间自动生成SQL语句执行。

四、工具篇
      
      JUnit单元测试
      JUnit是一套基于测试驱动开发的测试框架。

      注：
      JUnit4不需要继承junit.framework.TestCase类。
      JUnit3中所有的方法都必须使用@Test注解，并且需要在方法名前加test作为前缀，需要继承junit.framework.TestCase类。

      版本管理工具SVN
      SVN是一个开放源代码的版本控制系统。

      举个例子：
      ①个人的代码→口袋里的钱
      ②版本控制工具中的代码→卡里的钱
      ③版本控制工具中的客户端→卡
      ④版本控制工具中的服务端→刷卡机

      注：在实际版本管理当中，你所写的代码，需要提交给服务端，然后别人要修改你的代码，就会从服务端更新当前目录下的代码，再进行修改和提交。所以，“卡里的钱”可以理解为团队公有的代码体系。

      项目管理工具maven
      maven是基于项目对象模型（POM），可以通过一小段描述信息来管理项目的构建、报告和文档的软件项目管理工具。

      注：
      maven也是一套强大的自动化的管理工具，覆盖了编译、测试、运行、清理、打包和部署，整个项目构建的周期。
