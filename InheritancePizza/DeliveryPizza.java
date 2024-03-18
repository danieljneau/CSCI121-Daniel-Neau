//Imports ArrayList module
import java.util.ArrayList;
//Creates a subclass of Pizza
public class DeliveryPizza extends Pizza{
    //Creates variables for delivery fee and address
    private float delivFee;
    private String address;
    //Sets the Constructor to accept a list of toppings and an address
    public DeliveryPizza(ArrayList<String> toppings, String address) {
        super(toppings);
        this.address = address;
        //If the price of the pizza is over $18.00 charges a $3 delivery fee but if it is under $18 charges a $5 delivery fee
        if(super.getPrice()>18.00){
            delivFee = 3.00F;
        }
        else{
            delivFee = 5.00F;
        }
        super.setPrice(super.getPrice()+ delivFee);
    }
    //Creates the string representation for a delivary Pizza
    public String toString(){
        return super.toString() + " Your Address is: " + address;
    }
}
