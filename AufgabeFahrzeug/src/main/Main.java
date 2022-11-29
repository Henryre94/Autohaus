package main;

import  storage.Autohaus;
import vehicles.Car;
import vehicles.Truck;
import vehicles.Vehicle;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { ;

       Autohaus dealerShip = new Autohaus("El Patron",3,3);

        Scanner scanner = new Scanner(System.in);

        /**
         * 4 Fahrzeuge in der Variable inventory von der Klasse Autohaus durch
         */
        dealerShip.setVehicleList("CAR",1,"Audi",37000,2001,2016);
        dealerShip.setVehicleList("CAR",2,"VW",35000,2015,2017);
        dealerShip.setVehicleList("CAR",3,"Audi",35000,2015,2016);
        dealerShip.setVehicleList("TRUCK",4,"BMW",750000,2010,2012);

       //AUFGABE 5 PUNKT 7
        /**
         * Die for-Schleife check alle Fahrzeuge in der Variable Inventory und vergleich sie mit instanceof
         * Falls ein "Car" ist, wird die int Variable numberOfCar um 1 erhöht. Das selbes lauf bei numberOfTrucks
         */
        int numberOfCars = 0;
        int numberOfTrucks = 0;
        for (Vehicle inventory : dealerShip.getInventory()){
            if(inventory instanceof Car){
                numberOfCars++;
            }else if (inventory instanceof Truck){
                numberOfTrucks++;
            }
        }
        System.out.println(" ");
        System.out.println("WELCOME TO THE ADMINISTRATION SYSTEM OF THE DEALERSHIP " +dealerShip.getName() + ". THIS IS THE CURRENT INVENTORY");
        System.out.println("-------------------------------");

        System.out.println("Current Number of vehicles in the Dealership: " + dealerShip.numberOfVehicles());
        System.out.println("Number of Cars :" +numberOfCars);
        System.out.println("Number of Trucks :" +numberOfTrucks);
        System.out.println("-------------------------------");

        //AUFGABE 5 Punkt 8
        System.out.println("VEHICLE REGISTRATION AND MANUFACTURES");
        System.out.println(" ");

        /**
         * Dieser For-Schleife geht durch jedes Fahrzeug im Autohaus und für jedes Fahrzeug werden die sout ausgegeben.
         * Falls die Nummer von schon ausgedruckten Fahrzeugen kleiner als die Anzahl von Fahrzeugen ist, wird die For-Schleife weiter laufen.
         * Falls die Nummer von schon ausgedruckten Fahrzeugen gleich wie die Anzahl von Fahrzeugen ist, wird die zweite For-Schleife laufen.
         * Die zweite For-Schleife geht durch alle Fahrzeuge gespeichert in der Variable inventory im Autohaus (In diesen Fall 4) und bestätigt, ob sie PKW oder LKW sind.
         * Wenn PKW sind, die Hersteller für jeden PKW ausdrucken.
         * Wenn LKW sind, die Hersteller für jeden LKW ausdrucken.
         */
        for (int i = 1; i<= dealerShip.numberOfVehicles() ; i++){
            System.out.println("There is a new Vehicle in the Dealership. Number of Vehicles:" +i);
            if (i<dealerShip.numberOfVehicles())
                System.out.println("There are still vehicles to be register");
            if (i==dealerShip.numberOfVehicles())
                for (Vehicle manufacturerFromTheVehicles : dealerShip.getInventory()){
                    if(manufacturerFromTheVehicles instanceof Car){
                        System.out.println("Autos Manufactures :" + manufacturerFromTheVehicles.getManufacturer());
                    } else if (manufacturerFromTheVehicles instanceof Truck){
                        System.out.println("Truck Manufactures :" + manufacturerFromTheVehicles.getManufacturer());
                    }
                }
        }
        System.out.println("-------------------------------");
        //AUFGABE 5 PUNKT 8 FINITO
        /**
         * Der boolean showCurrentList wir uns erlauben ein Loop zu erzeugen. Wenn der User im String showData "No" oder "Yes" eintippen
         * wandelt der boolean zu True und die While-Schleife wird beenden.
         * Im Fall "Yes" wird mitteln eine For-Schleife die zurzeit Liste von Fahrzeugen.
         * Im Fall "No" wird nichts angezeigt.
         * Im Fall etwas anders wird eingetippt, eine Fehlermeldung wird angegeben.
         */
        boolean showCurrentList = false;
        while (!showCurrentList) {
            System.out.println("Access the current List of vehicles: Yer or No");
            String showData = scanner.nextLine();
            if (showData.equalsIgnoreCase("Yes")) {
                for (Vehicle count : dealerShip.getInventory()) {
                    System.out.println(count);
                    showCurrentList = true;
                }
            } else if (showData.equalsIgnoreCase("No")) {
                showCurrentList = true;
            } else {
                System.out.println("ERROR: Please type either YES or NO");
            }
        }

        //AUFGABE 5 PUNKT 7 FINITO
        /**
         * Wenn Anzahl an PKWs und Anzahl an LKWs gleich ist, wird ausgedruckt "There are the same amount of Cars and Trucks"
         * Wenn Anzahl an PKWs und Anzahl an LKWs ungleich ist, wird ausgedruckt "There are not the same amount of Cars and Trucks"
         */
        System.out.println("-------------------------------");
        System.out.println("COMPARISON BETWEEN TYPE OF VEHICLE:");
      if (numberOfCars == numberOfTrucks)
           System.out.println("There are the same amount of Cars and Trucks");
       else
           System.out.println("There are not the same amount of Cars and Trucks");
        System.out.println("-------------------------------");

        /**
         * Unklar ob es verwendet wird.
         */
/*        for (Vehicle newDiscount: dealerShip.getInventory())
       switch (newDiscount.getManufacturer()){
           case "Audi":
              double discount= (newDiscount.getRabatt()*5.0/2.0);
              double newPriceForAudi = (newDiscount.basePrice - newDiscount.getBasePrice()*discount);
              System.out.println("The price for the vehicle manufacturer by: "+newDiscount.getManufacturer()+
               "With the ID" +newDiscount.getId() +"is :"+newPriceForAudi );
           case "Mercedes":
               discount= (newDiscount.getRabatt()*5.0/2.0 + 0.1);
               double newPriceForMercedes   = (newDiscount.basePrice - newDiscount.getBasePrice()*discount);
               System.out.println("The price for the vehicle manufacturer by: "+newDiscount.getManufacturer()+
                       "With the ID" +newDiscount.getId() +"is :"+newPriceForMercedes );
           case "Volvo","VW":
               if(newDiscount.getBasePrice()%2==0) {
                   double price = 1500;
                   System.out.println("The price for the vehicle manufacturer by: "+newDiscount.getManufacturer()+
                           "With the ID" +newDiscount.getId() +"is :"+price );
               } else {
                   double price = 1700;
                   System.out.println("The price for the vehicle manufacturer by: "+newDiscount.getManufacturer()+
                           "With the ID" +newDiscount.getId() +"is :"+price);
               }
               break;
           default:
               System.out.println("The price could  not be calculated because the Manufacturer is unknown");
       }*/
        /**
         * Die Kombination von einem boolean und eine While-Schleife erlaubt uns wieder ein Loop zu erzeugen.
         * Hier kann der/die User/in entscheiden, ob er/sie noch ein weiteres Fahrzeug eingespeichert wird.
         * Der/die User/in kann entscheiden, ob ein "Car" oder ein "Truck" gespeichert wird.
         * Falls eine andere Art von Fahrzeug eingetippt ist, wird eine Fehlermeldung angezeigt.
         */
        boolean aux=false;
        while (aux==false){
            System.out.println("PLEASE DECLARE WHICH TYPE OF VEHICLE TO REGISTER IN THE DATABASE");
            String carOrTruck = scanner.nextLine();

            if (carOrTruck.equalsIgnoreCase("Car")) {

                String typeOfVehicle = "Car";
                /**
                 * Es ist nicht erlaubt ein Fahrzeug mit einem schon vorhandenes ID zu speichern.
                 */
                System.out.println("ID : ");
                boolean sameID=false;
                int idCar=0;
                while (sameID ==false) {
                    idCar = Integer.parseInt(scanner.nextLine());
                    for (Vehicle ids : dealerShip.getInventory()) {
                        if (idCar == ids.getId()) {
                            sameID = false;
                            System.out.println("This ID is already in use, please use another One");
                            System.out.println("ID : ");
                            break;
                        } else {
                            sameID = true;
                        }
                    }
                }
                System.out.println("Manufacturer: ");
                String brandCar = scanner.nextLine();

                System.out.println("Standard Price :");
                int standardPriceCar = Integer.parseInt(scanner.nextLine());

                System.out.println("Assembly Year : ");
                int assemblyYearCar = Integer.parseInt(scanner.nextLine());

                System.out.println("Display Year: ");
                int displayYearCar = Integer.parseInt(scanner.nextLine());

                dealerShip.setVehicleList("Car",idCar, brandCar,standardPriceCar,assemblyYearCar,displayYearCar);


            }else if (carOrTruck.equalsIgnoreCase("Truck")){

                String typeOfVehicle = "Truck";

                System.out.println("ID : ");
                boolean sameID2=false;
                int idTruck=0;
                while (sameID2 ==false) {
                    idTruck = Integer.parseInt(scanner.nextLine());
                    for (Vehicle ids : dealerShip.getInventory()) {
                        if (idTruck == ids.getId()) {
                            sameID2 = false;
                            System.out.println("This ID is already in use, please use another One");
                            System.out.println("ID : ");
                            break;
                        } else {
                            sameID2 = true;
                        }
                    }
                }

                System.out.println("Manufacturer : ");
                String brandTruck = scanner.nextLine();

                System.out.println("Standard Price : ");
                int standardPriceTruck = Integer.parseInt(scanner.nextLine());

                System.out.println("Assembly Year : ");
                int assemblyYearTruck = Integer.parseInt(scanner.nextLine());

                dealerShip.setVehicleList("Truck",idTruck, brandTruck,standardPriceTruck,assemblyYearTruck,-1);

            }else{
                System.out.println("ATTENTION : That type of vehicle can not be register");
            }
            System.out.println("Do you want to register another Vehicle? Yes or No");
            String wantToContinue = scanner.nextLine();
            if (wantToContinue.equalsIgnoreCase("No")){
                aux=true;
            }

        }


        System.out.println("-------------------------------");

        //AUFGABE 5 PUNKT 10 FINITO
        /**
         * Hier werden mit der Hilfe eine For-Schleife alle Preise von jedem Fahrzeug im Autohaus angezeigt.
         */
        System.out.println("Current Prices Vehicles:");
        for (Vehicle cars : dealerShip.getInventory())
                System.out.println("Price after Discount: "+ cars.getBasePrice() + ". For the Vehicle ID: " + cars.getId());

        System.out.println("-------------------------------");

        //AUFGABE 5 PUNKT 10 FINITO

        //AUFGABE 5 PUNKT 11
        /**
         * Mit der Hilfe eine For-Schleife wird unterschieden mittels "instaceof", ob das Fahrzeug ein PKW oder ein LKW ist.
         * Es werden alle IDs angezeigt.
         */
        for (Vehicle check : dealerShip.getInventory())
            if(check instanceof Car){
                System.out.println("Vehicle ID: " + check.getId() + " is a Car.");
            }else if (check instanceof Truck){
                System.out.println("Vehicle ID: " + check.getId() + " is a Truck.");
            }
        System.out.println("-------------------------------");

        //AUFGABE 5 PUNKT 11 FINITO

        /**
         * Hier wird angezeigt in welcher Lage das Autohaus sich befindet.
         * Anzahl an Fahrzeuge im Autohaus.
         * Überprüfen ob, das Verhältnis zwischen Mitarbeiter und Fahrzeuge größer als drei ist.
         * Überprüfen ob, genug Plätze für die Fahrzeuge gibt.
         */
        System.out.println("Situation at the Dealership : ");
        System.out.println(" ");
        System.out.println("Number of vehicles in the Dealership: " + dealerShip.numberOfVehicles());
        System.out.println("-------------------------------");

        for (Vehicle count : dealerShip.getInventory()){
            System.out.println(count);
        }
        System.out.println("-------------------------------");


        //AUFGABE 5 PUNKT 9
        System.out.println("More cars than Dealership Employees : " + dealerShip.tooManyVehicles());
        System.out.println("More cars than Park spaces : " + dealerShip.tooManyVehicles(dealerShip.numberOfVehicles(), 10));
        //AUFGABE 5 PUNKT 9 FINITO

    }
}
