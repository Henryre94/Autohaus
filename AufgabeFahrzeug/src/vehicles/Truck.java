package vehicles;

import java.time.LocalDate;
import java.util.Scanner;

public class Truck extends Vehicle {

    private  static final double ANNUAL_DISCOUNT = 0.06;
    private static final double MAX_DISCOUNT = 0.15;
    private static final double MIN_DISCOUNT = 0.00;

    Scanner scanner=new Scanner(System.in);

    /***
     *
     * @param id            Die Identifizierungsnummer für jedes Fahrzeug
     * @param manufacturer  Der Hersteller vom Fahrzeug
     * @param basePrice     Der Preis vom Fahrzeug
     * @param assemblyYear  Das Jahr, in dem das Fahrzeug hergestellt wurde.
     */
    public Truck(int id, String manufacturer, double basePrice, int assemblyYear){
        super(id,manufacturer,basePrice,assemblyYear);
    }


    /***
     * getRabatt: Berechnet den Rabatt für jede LKWs
     */
    @Override
    public double getRabatt() {
        double discount = (LocalDate.now().getYear() - assemblyYear) * ANNUAL_DISCOUNT;

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
                "\nPrice after discount: " +  getBasePrice() +"\nAssembly Year: "+ assemblyYear);
    }
    /***
     * Alle Eigenschaften vom Fahrzeug in einer toString Methode.
     */
    @Override
    public String toString(){
        return "Truck{" +
                "Id=" + id +
                ", Manufacturer='" + manufacturer + '\'' +
                ", Assembly Year=" + assemblyYear +
                ", Price=" + basePrice +
                '}';
    }

}
