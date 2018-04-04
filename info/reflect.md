class 的使用
方法的反射
构造函数的反射
成员变量的反射
一、什么是class类
     在面向对象的世界里，万物皆对象。类是对象，类是java.lang.Class类的实例对象。另外class类只有java虚拟机才能new出来。
     任何一个类都是Class 类的实例对象。这实例对象有三种表达方式：

    public class User{
    }

    public class ClassTest{
    User u=new User();
     //方式1:
     Class c1=User.class;
    //方式2:
    Class c2=u.getClass();
    //方式3:
    Class c3=Class.forName("com.forezp.User");

    //可以通过类的类型创建该类的实例对象
    User user=(User)c1.newInstance();
    }
二、class类的动态加载
    Class.forName(类的全称);该方法不仅表示了类的类型，还代表了动态加载类。编译时刻加载类是静态加载、运行时刻加载类是动态加载类。

三、获取方法信息
    基本的数据类型，void关键字都Class 类的实例;可以通过getame();getSimpleName()获取类的名称。

    Class c1=String.class;
    Class c2=int.class;
    Class c3=void.class;
    System.out.println(c1.getName());
    System.out.println(c2.getSimpleName());
    获取类的所有方法，并打印出来：

    public static void printClassInfo(Object object){
            Class c=object.getClass();
            System.out.println("类的名称："+c.getName());

            /**
             * 一个成员方法就是一个method对象
             * getMethod()所有的 public方法，包括父类继承的 public
             * getDeclaredMethods()获取该类所有的方法，包括private ,但不包括继承的方法。
             */
            Method[] methods=c.getMethods();//获取方法
            //获取所以的方法，包括private ,c.getDeclaredMethods();

            for(int i=0;i<methods.length;i++){
                //得到方法的返回类型
                Class returnType=methods[i].getReturnType();
                System.out.print(returnType.getName());
                //得到方法名：
                System.out.print(methods[i].getName()+"(");

                Class[] parameterTypes=methods[i].getParameterTypes();
                for(Class class1:parameterTypes){
                    System.out.print(class1.getName()+",");
                }
                System.out.println(")");
            }
        }
    public class ReflectTest {

            public static void main(String[] args){
                    String s="ss";
                    ClassUtil.printClassInfo(s);
            }
    }
    运行：

    类的名称：java.lang.String

    booleanequals(java.lang.Object,)

    java.lang.StringtoString()

    inthashCode()


四、获取成员变量的信息
    也可以获取类的成员变量信息

     public static void printFiledInfo(Object o){

            Class c=o.getClass();
            /**
             * getFileds()获取public
             * getDeclaredFields()获取所有
             */
            Field[] fileds=c.getDeclaredFields();

            for(Field f:fileds){
                //获取成员变量的类型
                Class filedType=f.getType();
                System.out.println(filedType.getName()+" "+f.getName());
            }

        }
    public static void main(String[] args){
                    String s="ss";
                    //ClassUtil.printClassInfo(s);
                    ClassUtil.printFiledInfo(s);
            }
    运行：

    [C value
    int hash
    long serialVersionUID
    [Ljava.io.ObjectStreamField; serialPersistentFields
    java.util.Comparator CASE_INSENSITIVE_ORDER
    int HASHING_SEED
    int hash32

五、获取构造函数的信息

    public static void printConstructInfo(Object o){
            Class c=o.getClass();

            Constructor[] constructors=c.getDeclaredConstructors();
            for (Constructor con:constructors){
                System.out.print(con.getName()+”(“);

                Class[] typeParas=con.getParameterTypes();
                for (Class class1:typeParas){
                    System.out.print(class1.getName()+” ,”);
                }
                System.out.println(“)”);
            }
        }
     public static void main(String[] args){
                    String s="ss";
                    //ClassUtil.printClassInfo(s);
                    //ClassUtil.printFiledInfo(s);
                    ClassUtil.printConstructInfo(s);
            }
    运行：

    java.lang.String([B ,)
    java.lang.String([B ,int ,int ,)
    java.lang.String([B ,java.nio.charset.Charset ,)
    java.lang.String([B ,java.lang.String ,)
    java.lang.String([B ,int ,int ,java.nio.charset.Charset ,)
    java.lang.String(int ,int ,[C ,)
    java.lang.String([C ,boolean ,)
    java.lang.String(java.lang.StringBuilder ,)
    java.lang.String(java.lang.StringBuffer ,)



六、方法反射的操作

    获取一个方法：需要获取方法的名称和方法的参数才能决定一个方法。

    方法的反射操作：

    method.invoke(对象，参数列表);


    class A{

        public void add(int a,int b){
            System.out.print(a+b);
        }

        public void toUpper(String a){
            System.out.print(a.toUpperCase());
        }
    }
    public static void main(String[] args) {
            A a=new A();
            Class c=a.getClass();
            try {
                Method method=c.getMethod("add",new Class[]{int.class,int.class});
                //也可以 Method method=c.getMethod("add",int.class,int.class);
                //方法的反射操作
                method.invoke(a,10,10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    运行：

    20
    
    
    
    
获取类对象

     Class.forName(String clazzName)静态方法
     调用类的class属性，Person.class返回的就是Person的class对象（推荐使用）
     调用某个对象的getClass()方法
     具体使用还是要根据实际来选择，第一种方式是比较自由的，只要知道一个类名就可以了，其不会做该类是否存在的校验，第二种、第三种则会做校验

 获取类的信息
 
     获取类构造器
     
     Connstructor<T> getConstructor(Class<?>...parameterTypes):
     返回此Class对象对应类的带指定形参的public构造器
     Constructor<?>[] getConstructors():返回此Class对象对应类的所有public构造器
     Constructor<T>[] getDeclaredConstructor(Class<?>...parameterTypes):
     返回此class对象对应类的带指定参数的构造器，与构造器的访问权限无关
     Constructor<?>[] getDeclaredConstructors():返回此class对象对应类的所有构造器，与构造器的访问权限无关
     
     获取类成员方法
     
     Method getMethod(String name,Class<?>...parameterTypes):返回此class对象对应类的带指定形参的public方法
     Method[] getMethods():返回此class对象所表示的类的所有public方法
     Method getDeclaredMethod(string name,Class<?>...parameterTypes):
     返回此class对象对应类的带指定形参的方法，与方法访问权限无关
     Method[] getDeclaredMethods():返回此class对象对应类的全部方法，与方法的访问权限无关
     
     获取类成员变量
     
     Field getField(String name):返回此class对象对应类的指定名称的public成员变量
     Field[] getFields():返回此class对象对应类的所有public成员变量
     Field getDeclaredField(String name):返回此class对象对应类的指定名称的成员变量，与成员变量访问权限无关
     Field[] getDeclaredFields():返回此class对象对应类的全部成员变量，与成员变量的访问权限无关
     
     获取类注解
     
     <A extends Annotation>A getAnnotation(Class<A>annotationClass):
     尝试获取该class对象对应类上村子的指定类型的Annotation，如果该类型注解不存在，则返回null
     <A extends Annotation>A getDeclaredAnnotation(Class<A>annotationClass):
     这是Java 8中新增的，该方法获取直接修饰该class对象对应类的指定类型的Annotation，如果不存在，则返回null
     Annotation[] getAnnotations():返回修饰该class对象对应类上存在的所有Annotation
     Annotation[] getDeclaredAnnotations():返回修饰该Class对象对应类上存在的所有Annotation
     <A extends Annotation>A[] getAnnotationByType(Class<A>annotationClass):
     该方法的功能与前面介绍的getAnnotation()方法基本相似，但由于Java8增加了重复注解功能，
     因此需要使用该方法获取修饰该类的指定类型的多个Annotation
     <A extends Annotation>A[] getDeclaredAnnotationByType(Class<A>annotationClass):
     该方法发功能与前面介绍的getDeclaredAnnotations()方法相似，也是因为Java8的重复注解的功能，
     需要使用该方法获取直接修饰该类的指定类型的多个Annotation
     
     获取该类内部类
     
     Class<?>[] getDeclaredClasses():返回该class队形对应类里包含的全部内部类
     
     获取该类对象所在的外部类
     
     Class<?> getDeclaringClass():返回该Class对象对应类所在的外部类
     
     获取该类对象对应类所实现的接口
     
     Class<?>[] getInterfaces():返回该Class对象对应类所实现的全部接口
     
     获取该类对象对应类所继承的父类
     
     Class<? super T> getSuperclass():返回该Class对象对应类的超类的Class对象
     
     获取该类对象对应类的修饰符、所在包、类名等基本信息
     
     int getModifiers():返回此类或接口的所有修饰符，修饰符由public、protected、private、final、static、abstract等
     对应的常量组成，返回的整数应使用Modifier工具类的方法来解码，才可以获取真是的修饰符
     Package getPackage():获取该类的包
     String getName():以字符串形式返回此CLass对象所表示的类的简称
     判断该类是否为接口、枚举、注解类型
     boolean isAnnotation():返回此class对象是否表示一个注解类型
     boolean isAnnotationPresent(Class<? extends Annotation>annotationClass):
     判断此Class对象是否使用类Annotation修饰
     boolean isAnonymousClass():返回此class对象是否是一个匿名类
     boolean isArray():返回此class对象是否表示一个数组类
     boolean isEnum():返回此class对象是否表示一个枚举
     boolean isInterface():返回此class对象是否表示一个接口
     boolean isInstance(Object obj):判断obj是否是此class对象的实例，该方法可以完全代替instanceof操作符
     public interface Colorable {
          public void value();
     }
     public class ClassInfo {

         public static void main(String[] args) throws NoSuchMethodException, SecurityException {
             Class<Colorable> cls=Colorable.class;
             System.out.println(cls.getMethod("value"));
             System.out.println(cls.isAnnotation());
             System.out.println(cls.isInterface());
    }

     }
     结果

     public abstract void com.em.Colorable.value()
     false
     true
     Java8中新增的方法参数反射
     int getParameterCount():获取该构造器或方法的形参个数
     Parameter[] getParameters():获取该构造器或方法的所有形参
     getModifiers():获取修饰该形参的修饰符
     String getName():获取形参名
     Type getParameterizedType():获取带泛型的形参类型
     Class<?>getType():获取形参类型
     boolean isNamePresent():该方法返回该类的class文件中是否包含了方法的形参名信息
     boolean isVarArgs():该方法用于判断该参数是否为个数可变的形参
     public class Test {
         public void getInfo(String str,List<String>list){
             System.out.println("成功");
         }
     }
     public class ClassInfo {

         public static void main(String[] args) throws NoSuchMethodException, SecurityException {
             Class<Test> cls=Test.class;
             Method med=cls.getMethod("getInfo", String.class,List.class);
             System.out.println(med.getParameterCount());
             Parameter[] params=med.getParameters();
             System.out.println(params.length);
             for(Parameter par:params){
                 System.out.println(par.getName());
                 System.out.println(par.getType());
                 System.out.println(par.getParameterizedType());
             }
         }

     }
          结果

          2
          2
          arg0
          class java.lang.String
          class java.lang.String
          arg1
          interface java.util.List
          java.util.List<java.lang.String>
          反射生成对象
          使用Class对象的newInstance()方法创建Class对象的实例，该方法要求要有默认构造器（比较常用）
          先使用Class对象获取指定的Constructor对象，在调用Constructor对象的newInstance()方法来创建该Class对象对应类的实例
          反射调用方法
          Object invoke(Object obj,Object...args):该方法中的obj是执行该方法的主调，后面的args是执行该方法时传入该方法的实参
          public class Test {

              public Test(String str) {
                  System.out.println(str);
              }
              public void getInfo(String str){
                  System.out.println(str);
              }
          }
     public class ClassInfo {

         public static void main(String[] args) throws Exception {
             Class<Test> cls=Test.class;
             Constructor<Test>construct=cls.getConstructor(String.class);
             Test test=construct.newInstance("初始化");
             Method med=cls.getMethod("getInfo", String.class);
             med.invoke(test, "调用方法成功");
         }

     }
          结果

          初始化
          调用方法成功
          接下来看官仔细看下面的栗子

     public class Test {

         public Test(String str) {
             System.out.println(str);
         }
         //私有方法
         private void getInfo(String str){
             System.out.println(str);
         }
     }
     public class ClassInfo {

         public static void main(String[] args) throws Exception {
             Class<Test> cls=Test.class;
             Constructor<Test>construct=cls.getConstructor(String.class);
             Test test=construct.newInstance("初始化");
           //为啥使用这个方法呢？
             Method med=cls.getDeclaredMethod("getInfo", String.class);
           //为啥使用这个方法呢？
             med.setAccessible(true);
             med.invoke(test, "调用方法成功");
         }

     }
     结果

     初始化
     调用方法成功
     setAccessible(boolean flag):将值设为true，指示该Method在使用是应该取消Java语言的访问权限检查

     访问成员变量值
     getXxx(Object obj):获取obj对象的该成员变量的值。此处的Xxx对应8种基本类型，如果该成员变量的类型是引用类型的，则去掉Xxx部分
     setXxx(Object obj,Xxx val):将obj对象的该成员变量设置为val值。此处的Xxx对应8中基本类型，如果该成员变量的类型是引用类型，则取消set后面的Xxx
     以上两个方法可以方法所有的成员变量，包括private的私有成员变量

     public class Test {
         private int num;

         public Test(String str) {
             System.out.println(str);
         }
         private void getInfo(String str){
             System.out.println(str);
         }
         public int getNum() {
             return num;
         }
         public void setNum(int num) {
             this.num = num;
         }

     }
     public class ClassInfo {

         public static void main(String[] args) throws Exception {
             Class<Test> cls=Test.class;
             Constructor<Test>construct=cls.getConstructor(String.class);
             Test test=construct.newInstance("初始化");
             Method med=cls.getDeclaredMethod("getInfo", String.class);
             med.setAccessible(true);
             med.invoke(test, "调用方法成功");
             Field fld=cls.getDeclaredField("num");
             fld.setAccessible(true);
             fld.setInt(test, 12);
             System.out.println(fld.getInt(test));
         }

     }
     结果

     初始化
     调用方法成功
     12
     操作数组
     java.lang.reflect包下有一个Array类，其可以动态创建数组

     static Object newInstance(Class<?>componentType,int...length):创建一个具有指定的元素类型、指定维度的新数组

     static xxx getXxx(Object array,int index):返回array数组中第index个元素。其中xxx是各种基本数据类型，如果数组元素是引用类型，则该方法变为get()

     static void setXxx(Object array,int index,xxx val):将array数组中低index 个元素的值设为val，其中xxx是各种基本数据类型，如果数组元素是引用类型，则该方法变为set()

     public class ArrayInfo {

         public static void main(String[] args) {
             Object arrays=Array.newInstance(String.class, 3);
             Array.set(arrays, 0, "第一个");
             Array.set(arrays, 1, "第二个");
             Array.set(arrays, 2, "第三个");
             System.out.println(Array.get(arrays, 2));
         }
     }
