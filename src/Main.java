class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class Main {

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array == null) {
            throw new MyArraySizeException("Массив не может быть null");
        }

        if (array.length != 4) {
            throw new MyArraySizeException("Неверное количество строк. Ожидается: 4, получено: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new MyArraySizeException("Строка " + i + " не может быть null");
            }

            if (array[i].length != 4) {
                throw new MyArraySizeException("Неверное количество столбцов в строке " + i +
                        ". Ожидается: 4, получено: " + array[i].length);
            }
        }

        System.out.println("Массив размера 4x4 принят на обработку");

        // Суммирование элементов с проверкой данных
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                    System.out.println("Ячейка [" + i + "][" + j + "] = " + value + " (сумма: " + sum + ")");
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Некорректные данные в ячейке [" + i + "][" + j + "]: '" +
                            array[i][j] + "'");
                }
            }
        }
        return sum;
    }

    public static void generateArrayIndexOutOfBoundsException() {
        System.out.println("\n=== Генерация ArrayIndexOutOfBoundsException ===");
        int[] array = {1, 2, 3, 4, 5};

        try {
            System.out.println("Пытаемся получить элемент array[10]...");
            int value = array[10];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Массив имеет размер: " + array.length);
            System.out.println("Пытались получить индекс: 10");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ MyArraySizeException ===\n");

        String[][] goodArray = new String[4][4];
        String[][] badArray = new String[5][5];
        String[][] wrongColumnsArray = new String[4][3];

        // Заполняем goodArray тестовыми данными
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                goodArray[i][j] = String.valueOf(i * 4 + j + 1); // "
            }
        }

        // Заполняем wrongColumnsArray
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                wrongColumnsArray[i][j] = "1";
            }
        }

        // Тест 1: Корректный массив
        try {
            System.out.println("Тест 1: Корректный массив 4x4");
            int result = processArray(goodArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        // Тест 2: Массив 5x5
        try {
            System.out.println("\nТест 2: Массив 5x5");
            processArray(badArray);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        // Тест 3: Массив 4x3
        try {
            System.out.println("\nТест 3: Массив 4x3");
            processArray(wrongColumnsArray);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        System.out.println("\n=== ТЕСТИРОВАНИЕ MyArrayDataException ===\n");

        // Тестовые массивы для проверки MyArrayDataException
        String[][] arrayWithText = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrayWithSymbol = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "@", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrayWithEmpty = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrayWithFloat = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11.5", "12"},
                {"13", "14", "15", "16"}
        };

        // Тест 4: Массив с текстом "seven"
        try {
            System.out.println("Тест 4: Массив с текстом 'seven'");
            int result = processArray(arrayWithText);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        // Тест 5: Массив с символом "@"
        try {
            System.out.println("\nТест 5: Массив с символом '@'");
            int result = processArray(arrayWithSymbol);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        // Тест 6: Массив с пустой строкой
        try {
            System.out.println("\nТест 6: Массив с пустой строкой");
            int result = processArray(arrayWithEmpty);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        // Тест 7: Массив с дробным числом "11.5"
        try {
            System.out.println("\nТест 7: Массив с дробным числом '11.5'");
            int result = processArray(arrayWithFloat);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        // Тест 8: null массив
        try {
            System.out.println("\nТест 8: null массив");
            int result = processArray(null);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        // Тест 9: Массив с null строками
        String[][] arrayWithNullRow = new String[4][4];
        arrayWithNullRow[0] = new String[]{"1", "2", "3", "4"};
        arrayWithNullRow[1] = null;  // null строка!
        arrayWithNullRow[2] = new String[]{"9", "10", "11", "12"};
        arrayWithNullRow[3] = new String[]{"13", "14", "15", "16"};

        try {
            System.out.println("\nТест 9: Массив с null строкой");
            int result = processArray(arrayWithNullRow);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        
        generateArrayIndexOutOfBoundsException();
    }
}