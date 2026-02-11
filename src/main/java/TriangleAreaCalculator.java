public class TriangleAreaCalculator {
    public static double calculateArea( double base, double height){
        if (base <= 0 || height <= 0){
            throw new IllegalArgumentException("Основание или высота должны быть больше 0");
        }
        return 0.5 * base * height;
    }

}
