public class MyClass {

    @Name(value = "注解写的名字")
    private String name;

    @MyAnnotation(value = "自定义注解的值")
    private void myMethod() {
        System.out.println("执行 myMethod");
    }
}
