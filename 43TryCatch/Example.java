
public class Example {
    //自定义异常类
    public class  MyException extends  Exception{
        public MyException(String message){
            super(message);
        }
    }
    //自定义方法，抛出自定义异常
    public void myMethod() throws MyException{
        if(true){
            throw new MyException("自定义异常");
        }
    }
    public static void main(String[] args) {
        Example example = new Example();
        try {
            example.myMethod();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}