package vehicles;

import java.time.LocalDate;
import java.util.Scanner;

public class Car extends Vehicle {

    private int displayYear;
    private final double ANNUAL_DISCOUNT = 0.05;
    private final double MAX_DISCOUNT = 0.10;
    private final double MIN_DISCOUNT = 0.00;
    private final double DISPLAY_DISCOUNT= 0.03;


    Scanner scanner=new Scanner(System.in);

    /***
     * @param id            Die Identifizierungsnummer für jedes Fahrzeug
     * @param manufacturer  Der Hersteller vom Fahrzeug
     * @param basePrice     Der Preis vom Fahrzeug
     * @param assemblyYear  Das Jahr, in dem das Fahrzeug hergestellt wurde.
     * @param displayYear   Ein Parameter nur für PKWs. Das vorführwagenJahr
     */
    public Car(int id, String manufacturer, double basePrice, int assemblyYear, int displayYear){
        super(id,manufacturer,basePrice,assemblyYear);
        this.displayYear=displayYear;
    }


    /***
     * getRabatt: Berechnet den Rabatt für jede PKWs.
     */
    @Override
    public double getRabatt() {
        double discount = ((LocalDate.now().getYear() - assemblyYear) * ANNUAL_DISCOUNT)+((displayYear - assemblyYear) * DISPLAY_DISCOUNT);

        if (discount > MAX_DISCOUNT) {
            discount = MAX_DISCOUNT;
        } else if (discount < MIN_DISCOUNT) {
            discount = MIN_DISCOUNT;
        }
        return discount;
    }


    /***
     * Alle Eigenschaften vom Fahrzeug.
     */
    @Override
    public void showMeTheSpecs() {
        System.out.print("Brand: "+ manufacturer+"\nPrice: " +basePrice +
                "\nPrice after discount: " +  getRabatt() +"\nAssembly Year: "+ assemblyYear+"\nDisplay year: "+displayYear);
    }
    /***
     * Alle Eigenschaften vom Fahrzeug in einer toString Methode.
     */
    @Override
    public String toString() {
        return "Car{" +
                "Id=" + id +
                ", Manufacturer'" + manufacturer + '\'' +
                ", Assembly Year=" + assemblyYear +
                ", Price=" + basePrice +
                ", Display Year=" + displayYear +

                '}';
    }

    //Getter und Setter

    public int getDisplayYear(){
        return displayYear;
    }
    public int setDisplayYear(int jahr){
        if(jahr>LocalDate.now().getYear() && jahr<assemblyYear){
            System.out.println("Das Jahr passt nicht!");
        }else {
            displayYear=jahr;
        }
        return jahr;
    }

}
