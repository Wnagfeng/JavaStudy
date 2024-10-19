class OriginalException extends Exception {
    public OriginalException(String message) {
        super(message);
    }
}

class NewException extends Exception {
    public NewException(String message, Throwable cause) {
        super(message, cause); // 持有原始异常
    }
}

public class ExceptionHandlingDemo {

    public static void riskyMethod() throws OriginalException {
        // 模拟一个方法，抛出 OriginalException
        throw new OriginalException("这是原始异常！");
    }

    public static void main(String[] args)throws NewException {
        try {
            riskyMethod(); // 调用可能抛出异常的方法
        } catch (OriginalException e) {
            System.out.println("捕获到原始异常: " + e.getMessage());
            // 捕获到异常后，抛出一个新的异常，并将原始异常作为原因
            throw new NewException("抛出新的异常！", e);
        } catch (Exception e) {
            System.out.println("捕获到其他异常: " + e.getMessage());
        }
    }
}
