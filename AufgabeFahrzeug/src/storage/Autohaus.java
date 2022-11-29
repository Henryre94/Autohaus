package storage;

import vehicles.Car;
import vehicles.Truck;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Autohaus{

    private ArrayList<Vehicle> inventory;
    private int storageRooms;
    private boolean overloaded;
    private int dealershipEmployee;
    private String name;

    Scanner scanner=new Scanner(System.in);

    /***
     * @param inventory         List von Fahrzeuge, die im Autohaus gespeichert sind.
     * @param name              Der Name vom Autohaus
     * @param storageEmployee   Anzahl von Mitarbeiter im Autohaus
     * @param storageRooms      Anzahl von Plätze im Autohaus
     */
    public Autohaus(String name, int storageEmployee, int storageRooms){ //Konstruktor
        inventory = new ArrayList<>();
        this.name=name;
        this.dealershipEmployee=storageEmployee;
        this.storageRooms=storageRooms;
    }

    /***
     * numberOfVehicles ist eine Methode, um die Zahl des Fahrzeuges im Autohaus zurückzugeben
     */
    public int numberOfVehicles(){
        return inventory.size();
    }

    /***
     * setVehicleList ist eine Methode, um ein Fahrzeug entweder PKW oder LKW in der Variable inventory einzuspeichern.
     * @param typeOfVehicle Zu spezifizieren, ob das Fahrzeug ein PKW oder ein LKW ist.
     * @param id            Die Identifizierungsnummer für jedes Fahrzeug
     * @param manufacturer  Der Hersteller vom Fahrzeug
     * @param basePrice     Der Preis vom Fahrzeug
     * @param assemblyYear  Das Jahr, in dem das Fahrzeug hergestellt wurde.
     * @param displayYear   Ein Parameter nur für PKWs. Das vorführwagenJahr
     */
    public void setVehicleList(String typeOfVehicle, int id,String manufacturer, int basePrice , int assemblyYear, int displayYear) {
        if (typeOfVehicle.equalsIgnoreCase("Car")){
            inventory.add(new Car(id, manufacturer,basePrice,assemblyYear,displayYear));
        }else if (typeOfVehicle.equalsIgnoreCase("Truck")){
            inventory.add(new Truck(id,manufacturer,basePrice,assemblyYear));
        }else {
            System.out.println("We don't sell that type of vehicle");
        }
    }


    /***
     * tooManyVehicles ist eine Methode, um die Anzahl an Fahrzeuge im Autohaus vs Mitarbeite zu berechnen.
     * 1 Mitarbeiter kann nur maximal 3 Fahrzeuge betreuen. Wenn das Verhältnis größer als 3 zu 1 ist, ist das
     * Autohaus overloaded.
     */
    public boolean tooManyVehicles(){

        if(inventory.size()/dealershipEmployee>3){
            overloaded = true;
            System.out.println("Autohaus is overloaded:" + overloaded);
            return overloaded;
        }else{
            overloaded = false;
            System.out.println("There is room");
        }
        return overloaded;
    }

    /***
     * Gleiche Methode aber dieses Mal wird die Anzahl von Fahrzeuge und Platze im Autohaus verglichen.
     * @param a Anzahl an Fahrzeuge im Autohaus.
     * @param b Anzahl an Plätze im Autohause
     *
     */
    public boolean tooManyVehicles(int a, int b){
        a=inventory.size();
        b=storageRooms;
        if (a<=b) {
            overloaded=true;
            System.out.println("Autohaus is overloaded: " + overloaded);
            return overloaded;
        }else if (a==b){
            overloaded =false;
            System.out.println("Storage room is full");
            return overloaded;
        }else{
            overloaded=false;
            System.out.println("There is room");
        }
        return overloaded;
    }

    /***
     * Der Name des Autohauses.
     */
    public void storageName(){
        System.out.println(name);
    }


    public ArrayList<Vehicle> getInventory(){
        return inventory;
    }
    public void setNumberOfVehicles(ArrayList<Vehicle> vehicleList){
        this.inventory = vehicleList;
    }
    public int getStorageRooms(){
        return storageRooms;
    }
    public void setStorageRooms(int storageRooms){
        this.storageRooms=storageRooms;
    }
    public int getStorageEmployee(){
        return dealershipEmployee;
    }
    public void setStorageEmployee(int storageEmployee){
        this.dealershipEmployee=storageEmployee;
    }
    public boolean overloaded(){
        return overloaded;
    }
    public void setOverloaded(boolean overloaded){
        this.overloaded=overloaded;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }


}

