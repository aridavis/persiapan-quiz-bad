public class Ojek extends  Vehicle{
    private String service;

    public Ojek(String license, String type, String driverName, String name, String service) {
        super(license, type, driverName, name);
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
