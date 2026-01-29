import java.util.Arrays;

public class Main {

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 5;
        int b = 1;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Cумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(){
        int value = 10;
        if (value <=0){
            System.out.println("Красный");
        }
        else if (value <= 100){
            System.out.println("Желтый");
        }
        else{
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = 1;
        int b = 5;
        if (a >= b){
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }

    public static boolean sumRange(int a, int b){
        int sum = a +b;
        return sum >=10 && sum <=20;


    }

    public static void printNumber(int a){
        if (a >=0){
            System.out.println("Положительное");
        }
        else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative (int number){
        return number < 0;
        }

    public static void numberAndString (int number, String str){
        for (int i = 0; i < number; i++){
            System.out.println(str);
        }
    }

    public static boolean isLeapYear (int year){
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 !=0);
    }

    public static void invertArray(){
        int arr[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                arr[i] = 1;
            }
            else {
                arr[i] =0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void array1To100(){
        int [] arr = new int [100];
        for (int i =0; i < arr.length; i++){
            arr[i] = i+1;
        }
        for (int i =0;i<5;i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println(arr[95] + " " + arr[96] + " " + arr[97] + " " + arr[98] + " " + arr[99]);
    }

    public static void arrayLess6(){
        int arr[] = {1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.println(Arrays.toString(arr));
        for (int i =0; i <arr.length;i++){
            if (arr[i] < 6){
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void diagonals(){
        int size = 3;
        int [][] matrix = new int [size][size];

        for (int i =0; i < size; i++){
            matrix[i][i] = 1;
            matrix[i][size -1 -i] = 1;
        }
        System.out.println("Матрица " + size + "x" + size + ":");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] createArray(int len, int initialValue){
        int [] arr = new int[len];
        for (int i =0; i<len;i++){
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void main (String[] args) {

        System.out.println("Задание 1");
        printThreeWords();

        System.out.println("Задание 2");
        checkSumSign();

        System.out.println("Задание 3");
        printColor();

        System.out.println("Задание 4");
        compareNumbers();

        System.out.println("Задание 5");
        System.out.println("Сумма 5 и 10" + sumRange(5,10));
        System.out.println("Сумма 10 и 10" + sumRange(10,10));
        System.out.println("Сумма 20 и 10" + sumRange(20,10));

        System.out.println("Задание 6");
        printNumber(5);
        printNumber(-1);
        printNumber(0);

        System.out.println("Задание 7");
        System.out.println(isNegative(-1));
        System.out.println(isNegative(0));
        System.out.println(isNegative(1));

        System.out.println("Задание 8");
        numberAndString(3, "Hello");

        System.out.println("Задание 9");
        System.out.println(isLeapYear(2026));
        System.out.println(isLeapYear(2000));

        System.out.println("Задание 10");
        invertArray();

        System.out.println("Задание 11");
        array1To100();

        System.out.println("Задание 12");
        arrayLess6();

        System.out.println("Задание 13");
        diagonals();

        System.out.println("Задание 14");
        int [] array = createArray(2,3);
        System.out.println(Arrays.toString(array));

    }
    }