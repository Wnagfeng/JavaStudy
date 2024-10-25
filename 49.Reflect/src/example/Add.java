package example;

public class Add implements MathOperation{

    @Override
    public int operation(int num1, int num2) {
        return num1 + num2;
    }
}
