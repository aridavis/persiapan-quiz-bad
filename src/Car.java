public class Car extends Vehicle{

    private Integer capacity;

    public Car(String license, String type, String driverName, String name, Integer capacity) {
        super(license, type, driverName, name);
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public Integer calculatePrice(Integer distance) {
        int totalPrice = 0;
        totalPrice += 15000;
        distance -= 5;
        if(distance > 0){
            totalPrice += (distance * 5000);
        }
        return totalPrice;
    }
}
