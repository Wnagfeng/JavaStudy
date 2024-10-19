class InitialException extends Exception {
    public InitialException(String message) {
        super(message);
    }
}

class ChainedException extends Exception {
    public ChainedException(String message, Throwable cause) {
        super(message, cause); // 将原始异常传递给父类
    }
}

public class ExceptionChainingDemo {

    // 模拟一个可能抛出异常的方法
    public static void firstMethod() throws InitialException {
        throw new InitialException("这是初始异常！");
    }

    public static void secondMethod() throws ChainedException {
        try {
            firstMethod(); // 调用可能抛出异常的方法
        } catch (InitialException e) {
            // 捕获 InitialException，抛出新的 ChainedException
            throw new ChainedException("抛出链式异常！", e); // 将原始异常传递
        }
    }

    public static void main(String[] args) {
        try {
            secondMethod(); // 调用第二个方法
        } catch (ChainedException e) {
            System.out.println("捕获到异常: " + e.getMessage());
            System.out.println("原始异常信息: " + e.getCause().getMessage());
        }
    }
}
