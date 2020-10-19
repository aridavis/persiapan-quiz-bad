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

    @Override
    public Integer calculatePrice(Integer distance) {
        Integer totalPrice = 0;
        totalPrice += 10000;
        distance -= 5;
        if(distance > 0){
            if( getService().equals("Food")){
                totalPrice += (distance * 2000);
            }
            else{
                totalPrice += (distance * 3500);
            }
        }
        return totalPrice;
    }
}
