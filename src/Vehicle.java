public abstract class Vehicle {
    private String license;
    private String type;
    private String driverName;
    private String name;

    public Vehicle(String license, String type, String driverName, String name) {
        this.license = license;
        this.type = type;
        this.driverName = driverName;
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
