### 实现步骤
获取字节码对象

使用 MyClass.class 获取 MyClass 类的字节码对象。
获取方法

使用 getDeclaredMethod("myMethod") 从字节码对象中获取名为 myMethod 的方法。这里是私有方法，所以使用 getDeclaredMethod。
检查方法的注解

使用 isAnnotationPresent(MyAnnotation.class) 检查 myMethod 方法上是否有 MyAnnotation 注解。
如果存在，则使用 getAnnotation(MyAnnotation.class) 获取该注解实例，并通过 annotation.value() 打印注解的值。
获取字段

使用 getDeclaredField("name") 从字节码对象中获取名为 name 的字段。
检查字段的注解

使用 isAnnotationPresent(Name.class) 检查 name 字段上是否有 Name 注解。
如果存在，则使用 getAnnotation(Name.class) 获取该注解实例，并通过 name.value() 打印字段的值。
创建实例

使用 new MyClass() 创建 MyClass 的实例，准备调用其方法。
调用方法

使用 setAccessible(true) 允许访问私有方法。
使用 invoke(myClassInstance) 调用 myMethod，执行其逻辑。
异常处理

使用 try-catch 块捕获可能的异常，包括 NoSuchMethodException、IllegalAccessException、InvocationTargetException 等。