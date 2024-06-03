# Java - Clone
# methods one
父类必须重写 clone() 方法，并实现Cloneable。
Cloneable接口是空接口，没有任何方法，仅仅用于标识一个类是可克隆的。
这种克隆叫做浅克隆(shallow clone)，即只克隆对象本身的成员变量，而不克隆对象间的引用。
```java
public class MyClass implements Cloneable {
    private int[] arr;   // 数组属性

    public MyClass(int[] arr) {
        this.arr = arr;
    }

    @Override
    public MyClass clone() throws CloneNotSupportedException {
        MyClass newObj = (MyClass) super.clone();  // 调用父类的 clone() 方法
        newObj.arr = this.arr.clone();  // 克隆数组属性
        return newObj;
    }
}
```

