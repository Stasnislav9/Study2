import java.util.ArrayList;

public class Park {
    private String parkName;
    private String location;

    public Park(String parkName, String location) {
        this.parkName = parkName;
        this.location = location;
    }

    public String getParkName() {
        return parkName;
    }

    public String getLocation() {
        return location;
    }

    public class Attraction {
        private String name;
        private String workHours;
        private double price;

        public Attraction(String name, String workHours, double price) {
            this.name = name;
            this.workHours = workHours;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getWorkHours() {
            return workHours;
        }

        public double getPrice() {
            return price;
        }
    }

    public static Park createParkWithAttractions() {
        Park myPark = new Park("Center Park", "Moscow");

        Park.Attraction attraction1 = myPark.new Attraction("Wheel", "10:00-22:00", 500.0);
        Park.Attraction attraction2 = myPark.new Attraction("American", "10:00-22:00", 500.0);

        return myPark;

    }
}