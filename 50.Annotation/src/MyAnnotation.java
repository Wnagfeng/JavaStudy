import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 定义元注解
@Retention(RetentionPolicy.RUNTIME) // 注解在运行时仍然可用
@Target(ElementType.METHOD) // 该注解只能用于方法
public @interface MyAnnotation {
    String value() default "默认值"; // 注解的元素
}

