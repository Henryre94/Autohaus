package vehicles;

public abstract class Vehicle {
    public int id;
    public String manufacturer;
    public int assemblyYear;
    public double basePrice;

    /***
     *
     * @param id            Die Identifizierungsnummer für jedes Fahrzeug
     * @param manufacturer  Der Hersteller vom Fahrzeug
     * @param basePrice     Der Preis vom Fahrzeug
     * @param assemblyYear  Das Jahr, in dem das Fahrzeug hergestellt wurde.
     */
    public Vehicle(int id, String manufacturer, double basePrice, int  assemblyYear){
        this.id=id;
        this.manufacturer=manufacturer;
        this.assemblyYear=assemblyYear;
        this.basePrice=basePrice;
    }

    /***
     * getRabatt : Abstrakte Methode, um der Rabatt zu berechnen. (Im Cars und Truck override)
     * showMeTheSpecs : Abstrakte Methode, um die Eigenschaften von den Fahrzeugen zu zeigen. (Im Cars und Truck override)
     */
    public abstract double getRabatt();
    public abstract void showMeTheSpecs();


    //Getter und Setter von der Abstraktklasse Vehicle that extends to Car and Truck

    public int getId(){
        return id;
    }
    public void setId(int truckId){
        this.id=truckId;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer=manufacturer;
    }
    public int getAssemblyYear(){
        return assemblyYear;
    }
    public void setAssemblyYear(int assemblyYear){
        this.assemblyYear=assemblyYear;
    }
    public double getBasePrice(){
        return basePrice -(basePrice* getRabatt());
    }
    public void setBasePrice(double basePrice){
        this.basePrice=basePrice;
    }

}
