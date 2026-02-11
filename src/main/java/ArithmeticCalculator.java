public class ArithmeticCalculator {
    public static int add (int a, int b){
        return a + b;
    }
    public static int subtract (int a, int b){
        return a - b;
    }
    public static int multiply (int a, int b){
        return a * b;
    }
    public static float divide (int a, int b){
        if (b ==0){
            throw new ArithmeticException("Деление на ноль");
        }
        return (float) a /b;
    }
}
