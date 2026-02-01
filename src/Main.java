import java.time.LocalDate;

public class Main {
    public static void main(String[] arg) {
        System.out.println("=== ЗАДАНИЕ 1: СОЗДАНИЕ ТОВАРА ===\n");
        Product product1 = new Product(
                "Ноутбук",
                LocalDate.of(2026, 1, 30),
                "HP",
                "Russia",
                150000.0
        );
        product1.display();

        System.out.println("\n=== ЗАДАНИЕ 2: МАССИВ ТОВАРОВ ===\n");

        Product[] productsArray = Product.createProductsArray();

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар #" + (i + 1) + ":");
            productsArray[i].display();
            System.out.println();
        }

        System.out.println("=== ЗАДАНИЕ 3: ПАРК С АТТРАКЦИОНАМИ ===\n");

        Park myPark = Park.createParkWithAttractions();

        System.out.println("Название парка: " + myPark.getParkName());
        System.out.println("Местоположение: " + myPark.getLocation());

        Park.Attraction attraction1 = myPark.new Attraction("Колесо обозрения", "10:00-22:00", 500.0);
        Park.Attraction attraction2 = myPark.new Attraction("Американские горки", "11:00-20:00", 750.0);
        Park.Attraction attraction3 = myPark.new Attraction("Детская карусель", "09:00-19:00", 300.0);

        Park.Attraction[] attractions = {attraction1, attraction2, attraction3};

        for (int i = 0; i < attractions.length; i++) {
            System.out.println("Аттракцион #" + (i + 1) + ":");
            System.out.println("  Название: " + attractions[i].getName());
            System.out.println("  Время работы: " + attractions[i].getWorkHours());
            System.out.println("  Стоимость: " + attractions[i].getPrice() + " руб.");
        }


    }
}
