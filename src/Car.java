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
}
