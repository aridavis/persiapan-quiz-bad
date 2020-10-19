import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    Vector<Vehicle> vehicles = new Vector<>();
    Scanner scan = new Scanner(System.in);

    private void enter(){
        for (int i = 0; i <30;i++){
            System.out.println();
        }
    }

    private void insertVehicle(){
        enter();

        String license;
        String type;
        String driverName;
        String name;

        while(true){
            System.out.print("Input Vehicle License: [X-Y-Z format]: ");
            license = scan.nextLine();

            String[] splitted = license.split("-");

            if(splitted.length != 3){
                continue;
            }

            // Validasi X
            String x = splitted[0];
            Boolean isValid = true;
            if(x.length() < 1 || x.length() > 2){
                continue;
            }

            for(int i = 0; i < x.length();i++){
                if(Character.isAlphabetic(x.charAt(i)) == false){
                    isValid = false;
                    break;
                }
            }

            if(isValid == false){
                continue;
            }

            // Validasi Y
            String y = splitted[1];
            if(y.length() < 1 || y.length() > 4){
                continue;
            }

            for(int i = 0; i < y.length();i++){
                if(Character.isDigit(y.charAt(i)) == false){
                    isValid = false;
                    break;
                }
            }

            if(isValid == false){
                continue;
            }

            // Validasi Z
            String z = splitted[2];
            if(z.length() < 1 || z.length() > 3){
                continue;
            }

            for(int i = 0; i < z.length();i++){
                if(Character.isAlphabetic(z.charAt(i)) == false){
                    isValid = false;
                    break;
                }
            }

            if(isValid == false){
                continue;
            }
            break;
        }

        // Validasi Vehicle Type
        do{
            System.out.print("Input Vehicle Type [SW-Car | SW-Ojek]: ");
            type = scan.nextLine();
        }while(type.equals("SW-Car") == false && type.equals("SW-Ojek") == false);

        do{
            System.out.print("Input Driver Name [5-30 chars]: ");
            driverName = scan.nextLine();
        }while(driverName.length() < 5 || driverName.length() > 30);

        do{
            System.out.print("Input Vehicle Name [5-20 chars]: ");
            name = scan.nextLine();
        }while(name.length() < 5 || name.length() > 20);

        Vehicle v;

        if(type.equals("SW-Car")){
            Integer capacity = 0;
            do{
                System.out.print("Input Capacity [4 - 6]: ");
                capacity = scan.nextInt();
                scan.nextLine();
            }while(capacity < 4 || capacity > 6);
            v = new Car(license, type, driverName, name, capacity);
        }
        else{
            String service = "";
            do{
                System.out.print("Input Service Type [Ride | Food]: ");
                service = scan.nextLine();
            }while (service.equals("Ride") == false && service.equals("Food") == false);
            v = new Ojek(license, type, driverName, name, service);
        }

        vehicles.add(v);
        System.out.println("Success Adding Vehicle");
        scan.nextLine();
    }

    public void chooseService(){
        enter();
        if(vehicles.isEmpty()){
            System.out.println("No vehicle");
            scan.nextLine();
        }
        else{
            for(int i = 0 ;i<vehicles.size();i++){
                Vehicle x = vehicles.get(i);
                System.out.println("No: " + (i+1));
                System.out.println("Driver Name: "  + x.getDriverName());
                System.out.println("Vehicle Name: "  + x.getName());
                System.out.print("Capacity: ");
                if(x instanceof Car){
                    System.out.println(((Car)x).getCapacity());
                }
                else{
                    System.out.println("-");
                }
                System.out.print("Service: ");
                if(x instanceof Ojek){
                    System.out.println(((Ojek) x).getService());
                }
                else{
                    System.out.println("-");
                }
            }

            Integer choice = 0;

            do{
                System.out.print("Choose Vehicle [1 - " + vehicles.size() + "]: ");
                choice = scan.nextInt();
                scan.nextLine();
            }while (choice < 1 || choice > vehicles.size());

            Vehicle chosen = vehicles.get(choice - 1);

            Integer distance = 0;
            do {
                System.out.println("Input Distance [more than or equals 1]");
                distance = scan.nextInt();
                scan.nextLine();
            }while(distance < 1);

            Integer totalPrice = 0;

            if(chosen.getType().equals("SW-Car")){
                totalPrice += 15000;
                distance -= 5;
                if(distance > 0){
                    totalPrice += (distance * 5000);
                }
            }
            else{
                totalPrice += 10000;
                distance -= 5;
                if(distance > 0){
                    if( ((Ojek)chosen).getService().equals("Food")){
                        distance += (distance * 2000);
                    }
                    else{
                        distance += (distance * 3500);
                    }
                }
            }

            System.out.println("Total Price: Rp. " + totalPrice);
            scan.nextLine();
        }
    }

    public Main(){
        Integer input = 0;

        do{
            enter();
            System.out.println("1. Insert New Vehicle");
            System.out.println("2. Use Vehicle Service");
            System.out.println("3. Delete Vehicle");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            input = scan.nextInt();
            scan.nextLine();

            if (input == 1){
                insertVehicle();
            }
            else if(input == 2){
                chooseService();
            }
            else if(input == 3){
                if(vehicles.isEmpty()){
                    System.out.println("No vehicle");
                    scan.nextLine();
                }
                else {
                    for (int i = 0; i < vehicles.size(); i++) {
                        Vehicle x = vehicles.get(i);
                        System.out.println("No: " + (i + 1));
                        System.out.println("Driver Name: " + x.getDriverName());
                        System.out.println("Vehicle Name: " + x.getName());
                        System.out.print("Capacity: ");
                        if (x instanceof Car) {
                            System.out.println(((Car) x).getCapacity());
                        } else {
                            System.out.println("-");
                        }
                        System.out.print("Service: ");
                        if (x instanceof Ojek) {
                            System.out.println(((Ojek) x).getService());
                        } else {
                            System.out.println("-");
                        }
                    }
                    Integer choice = 0;

                    do{
                        System.out.print("Choose Vehicle [1 - " + vehicles.size() + "]: ");
                        choice = scan.nextInt();
                        scan.nextLine();
                    }while (choice < 1 || choice > vehicles.size());

                    vehicles.removeElementAt(choice - 1);
                    System.out.println("Success Deleting Vehicles");
                    scan.nextLine();
                }
            }

        }while(input != 4);

    }

    public static void main(String[] args) {
        new Main();
    }
}
