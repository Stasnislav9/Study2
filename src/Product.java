import java.time.LocalDate;


public class Product {
    //Поля
    private String name;
    private LocalDate productDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean reserved;

    //Конструктор
    public Product (String name, LocalDate productDate, String manufacturer, String countryOfOrigin, double price){
        this.name = name;
        this.productDate = productDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reserved = false;
    }

    public void display (){
        System.out.println(name);
        System.out.println(productDate);
        System.out.println(manufacturer);
        System.out.println(countryOfOrigin);
        System.out.println(price);
        System.out.println(reserved);
    }
    public static Product[] createProductsArray() {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product(
                "Notebook", LocalDate.of(2026, 1, 30), "HP", "Russia", 150000.0
        );

        productsArray[1] = new Product(
                "Phone", LocalDate.of(2026, 1, 30), "Iphone", "USA", 100000.0
        );

        productsArray[2] = new Product(
                "Phone", LocalDate.of(2026, 1, 30), "Samsung", "Korea", 50000.0
        );

        productsArray[3] = new Product(
                "PlayStation", LocalDate.of(2026, 1, 30), "Sony", "Japan", 60000.0
        );

        productsArray[4] = new Product(
                "Smartwatch", LocalDate.of(2026, 1, 30), "Xiaomi", "China", 20000.0
        );

        return productsArray;
    }

}