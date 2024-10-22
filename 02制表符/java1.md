【JavaSE】反射、枚举、lambda表达式

鸽鸽程序猿

已于 2024-10-10 22:24:40 修改

阅读量3.2k
 收藏 141

点赞数 197
分类专栏： javaSE 文章标签： java
版权

西安城市开发者社区
文章已被社区收录
加入社区

javaSE
专栏收录该内容
13 篇文章29 订阅
订阅专栏
目录
一、反射
1.1 反射相关类
1.2 获取类中属性相关方法
1.2.1 常用获得类相关的方法
1.2.2 示例
1.2.3 常用获得类中属性相关的方法
1.2.4 示例
1.2.5 获得类中注解相关的方法
1.3 反射优缺点
二、枚举
2.1 常用方法
2.2 优缺点
三、枚举与反射
四、lambda表达式
4.1 语法
4.2 函数式接口
4.3 简化规则
4.4 使用示例
4.5 变量捕获
4.6 集合中的应用
4.7 优缺点
一、反射
Java的反射（reﬂection）机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
对于任意一个对象，都能够调用它的任意方法和属性，既然能拿到那么，我们就可以修改部分类型信息；
这种动态获取信息以及动态调用对象方法的功能称为java语言的反射（reﬂection）机制。
1.1 反射相关类
类名	用途
Class类	代表类的实体，在运行的Java应用程序中表示类和接口
Field类	代表类的成员变量/类的属性
Method类	代表类的方法
Constructor类	代表类的构造方法
1.2 获取类中属性相关方法
1.2.1 常用获得类相关的方法
方法	用途
getClassLoader()	获得类的加载器
getDeclaredClasses()	返回一个数组，数组中包含该类中所有类和接口类的对象(包括私有的)
forName(String className)	根据类名返回类的对象
newInstance()	创建类的实例
getName	获得类的完整路径名字
1.2.2 示例
获取类有以下三种方法：

通过getClass获取Class对象
类名 对象名 = new 类名();//初始化一个对象
Class 类变量名 = 对象名.getClass();
1
2
直接通过 类名.class 的方式得到。该方法最为安全可靠，程序性能更高
（ 这说明任何一个类都有一个隐含的静态成员变量 class）
 Class 类变量名 = 类名.class;
1
通过 Class 对象的 forName() 静态方法来获取，用的最多，
但可能抛出 ClassNotFoundException 异常
try {
	Class 类变量名 = Class.forName("包名.类名");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
1
2
3
4
5
1.2.3 常用获得类中属性相关的方法
方法	用途
getField(String name)	获得某个公有的属性对象
getFields()	获得所有公有的属性对象
getDeclaredField(String name)	获得某个属性对象
getDeclaredFields()	获得所有属性对象
1.2.4 示例
获取私有构造方法：（展示核心代码，要捕获异常）

//第一步：调用获取方法，参数与构造方法的类型的.class
Constructor<T> constructor = c1.getDeclaredConstructor(String.class , int.class);
//第二步：由于是私有的就要设置为可访问，相当于获取权限
constructor.setAccessible(true);
//第三步：使用构造方法获取一个对象
Object o = constructor.newInstance("kun",2.5);
            
1
2
3
4
5
6
7
1.2.5 获得类中注解相关的方法
方法	用途
getAnnotation(Class annotationClass)	返回该类中与参数类型匹配的公有注解对象
getAnnotations()	返回该类所有的公有注解对象
getDeclaredAnnotation(Class annotationClass)	返回该类中与参数类型匹配的所有注解对象
getDeclaredAnnotations()	返回该类所有的注解对象
1.3 反射优缺点
优点：

对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法
增加程序的灵活性和扩展性，降低耦合性，提高自适应能力
反射已经运用在了很多流行框架如：Struts、Hibernate、Spring 等等。
缺点：

使用反射会有效率问题。会导致程序效率降低。
反射技术绕过了源代码的技术，因而会带来维护问题。反射代码比相应的直接代码更复杂 。
二、枚举
枚举是在JDK1.5以后引入的。
主要用途是：将一组常量组织起来，在这之前表示一组常量通常使用定义常量的方
式：public static final
枚举语法（类内方法外）：

public enum 枚举名{
    RED,BLACK,GREEN;//定义的都相当于常量
}
1
2
3
2.1 常用方法
方法	用途
values()	以数组形式返回枚举类型的所有成员
ordinal()	获取枚举成员的索引位置
valueOf()	将普通字符串转换为枚举实例
compareTo()	比较两个枚举成员在定义时的顺序
枚举的构造方法默认是私有的，且只能是私有的。

2.2 优缺点
优点：

枚举常量更简单安全 。
枚举具有内置方法 ，代码更优雅 。
缺点： 不可继承，无法扩展 。

三、枚举与反射
当我们按照前面获取构造方法的方法获取枚举的构造方法时汇报异常：java java.lang.NoSuchMethodException
看源码会知道是因为除了我们自己的构造函数参数外，他默认后边还会给参数，也就是说，这里我们参数给少了。
正确给参数后还是会报java.lang.IllegalArgumentException
原因是newInstance方法源码中有如下判断：


四、lambda表达式
Lambda表达式是Java SE 8中一个重要的新特性。
lambda表达式允许你通过表达式来代替功能接口。
lambda表达式就和方法一样,它提供了一个正常的参数列表和一个使用这些参数的主体(body,可以是一个表达式或一个代码块)。
Lambda 表达式（Lambda expression），基于数学中的λ演算得名，也可称为闭包（Closure）。

4.1 语法
(parameters) -> expression 或 (parameters) ->{ statements; } 
1
paramaters：类似方法中的形参列表，这里的参数是函数式接口里的参数。这里的参数类型可以明确的声明也可不声明而由JVM隐含的推断。另外当只有一个推断类型时可以省略掉圆括号。
->：可理解为“被用于”的意思。
方法体：可以是表达式也可以代码块，是函数式接口里方法的实现。代码块可返回一个值或者什么都不返回，这里的代码块块等同于方法的方法体。如果是表达式，也可以返回一个值或者什么都不返回。
4.2 函数式接口
一个接口有且只有一个抽象方法，其他无关。
函数式接口可以加上@FunctionalInterface注解,加上后idea会自动帮你检验。

4.3 简化规则
参数类型可以省略，如果需要省略，每个参数的类型都要省略。
参数的小括号里面只有一个参数，那么小括号可以省略
如果方法体当中只有一句代码，那么大括号可以省略
如果方法体中只有一条语句，且是return语句，那么大括号可以省略，且去掉return关键字。
4.4 使用示例
MoreParameterNoReturn moreParameterNoReturn = ( a, b)->{
        System.out.println("无返回值多个参数，省略参数类型："+a+" "+b);
};

OneParameterNoReturn oneParameterNoReturn = a ->{
        System.out.println("无参数一个返回值,小括号可以胜率："+ a);
};

NoParameterNoReturn noParameterNoReturn = ()->System.out.println("无参数无返回值，方法体中只有一行代码");
1
2
3
4
5
6
7
8
9
4.5 变量捕获
lambda可以自动捕获上层的变量。
但是捕获到的变量不能够在修改，修改就会报错。

public static void main(String[] args) {
        int a = 10;
        NoParameterNoReturn noParameterNoReturn = ()->{
            // a = 99; error
            System.out.println("捕获变量："+a);
       };
        noParameterNoReturn.test();
}
1
2
3
4
5
6
7
8
4.6 集合中的应用


4.7 优缺点
优点：

代码简洁，开发迅速
方便函数式编程
非常容易进行并行计算
Java 引入 Lambda，改善了集合操作
缺点：

代码可读性变差
在非并行计算中，很多计算未必有传统的 for 性能要高
不容易进行调试
————————————————

                            版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
                        
原文链接：https://blog.csdn.net/yj20040627/article/details/142495033