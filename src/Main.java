class Animal {
    private String name;
    private int age;
    private static int animalCount = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int getAnimalCount(){
        return animalCount;
    }

    public void run(int distance){
        System.out.println(getName() + " пробежал " + distance + " м");
    }

    public void swim (int distance){
        System.out.println(getName() + " проплыл " + distance + " м");
    }

}
class Dog extends Animal{

        private String breed;
        private static final int max_run_distance = 500;
        private static final int max_swim_distance = 10;
        private static int dogCount = 0;

        public Dog(String name, int age, String breed){
            super(name, age);
            this.breed = breed;
            dogCount++;
        }

        public static int getDogCount(){
            return dogCount;
        }

        public String getBreed(){
            return breed;
        }

        @Override
        public void run(int distance){
            if (distance <= 0){
                System.out.printf("Не может бежать меньше 0");
            }
            else if (distance<= max_run_distance){
                System.out.println(getName() + " пробежал " + distance + " м");
            }
            else {
                System.out.println("Не может пробежать больше");
            }
        }

    @Override
    public void swim (int distance){
        if (distance <= 0){
            System.out.printf("Не может плыть меньше 0");
        }
        else if (distance<= max_swim_distance){
            System.out.println(getName() + " проплыл " + distance + " м");
        }
        else {
            System.out.println("Не может проплыть больше");
        }
    }
}

class Cat extends Animal{

    private String color;
    private boolean isFull;
    private static final int max_run_distance = 200;
    private static int catCount = 0;
    private static final int default_food_needed = 10;

    public Cat(String name, int age, String color){
        super(name, age);
        this.color = color;
        catCount++;
        this.isFull = false;
    }

    public static int getCatCount(){
        return catCount;
    }

    public String getColor(){
        return color;
    }

    public boolean isFull(){
        return isFull;
    }

    public static int getDefault_food_needed(){
        return default_food_needed;
    }

    public void eatBowl(Bowl bowl){
        if (isFull){
            System.out.println("Уже сытый");
            return;
        }

        if (bowl.feedCat(this, default_food_needed)){
            isFull = true;
            System.out.println(getName() + " поел и сыт");

        }
        else{
            System.out.println(getName() + " остался голодным");
        }
    }

    public void checkFull(){
        if (isFull){
            System.out.println(getName() + " сыт");
        }
        else {
            System.out.println(getName() + " голоден");
        }
    }

    @Override
    public void run(int distance){
        if (distance <= 0){
            System.out.printf("Не может бежать меньше 0");
        }
        else if (distance<= max_run_distance){
            System.out.println(getName() + " пробежал " + distance + " м");
        }
        else {
            System.out.println("Не может пробежать больше");
        }
    }

    @Override
    public void swim(int distance){
        System.out.println("Не умеет плавать");
    }
}

class Bowl{
    private int foodAmount;

    public Bowl(int initialAmount){
        if (initialAmount <= 0){
            this.foodAmount = 0;
            System.out.println("Не может быть меньше 0");
        }
        else {
            this.foodAmount = initialAmount;
        }
    }

    public int getFoodAmount(){
        return  foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Теперь в миске " + foodAmount + " еды");
        } else {
            System.out.println("Нельзя добавить 0");
        }
    }

    public boolean feedCat(Cat cat, int foodNeeded){
        if (foodNeeded <= 0){
            System.out.println("Нельзя покормить");
            return false;
        }

        if (foodAmount >= foodNeeded){
            foodAmount -= foodNeeded;
            return true;
        }
        else{
            System.out.println("Недостаточно еды");
            return false;
        }
    }

    public void printInfo(){
        System.out.println("В миске " + foodAmount + " еды");
    }
}

public class Main{
    public static void main (String[] args){

        Dog dog1 = new Dog("Bobik ", 5,"Pes");
        Dog dog2 = new Dog("Sharik", 5 , "Pesik");
        Cat cat1 = new Cat("Mila ", 5,"Koshka");
        Cat cat2 = new Cat("Barsik", 5 , "Kotenok");

        System.out.println();

        dog1.run(100);
        cat1.run(100);

        System.out.println();

        dog1.swim(10);
        cat1.swim(10);

        System.out.println();

        System.out.println(Animal.getAnimalCount());
        System.out.println(Dog.getDogCount());
        System.out.println(Cat.getCatCount());

        Bowl bowl = new Bowl(30);
        bowl.printInfo();

        Cat[] cats = {cat1, cat2};

        for (Cat cat : cats){
            cat.eatBowl(bowl);
        }

        for (Cat cat : cats){
            cat.checkFull();
        }

        bowl.printInfo();

        bowl.addFood(25);



    }
}
