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
                        if(Character.isDigit(z.charAt(i)) == false){
                            isValid = false;
                            break;
                        }
                    }

                    if(isValid == false){
                        continue;
                    }

                    break;
                }

            }

        }while(input != 4);

    }

    public static void main(String[] args) {
        new Main();
    }
}
