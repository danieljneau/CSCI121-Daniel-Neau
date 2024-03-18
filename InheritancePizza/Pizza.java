//Imports ArrayList module
import java.util.ArrayList;
//Creates the pizza class
public class Pizza {
    //Initializes the varubles needed
    private ArrayList <String> toppings;
    private float price;
    private String description;
    //I don't see the point of adding the number of toppings in the declaration.
    //Constructs the Pizza
    public Pizza(ArrayList <String> toppings){
        this.toppings = toppings;
        description = toppings.get(0);
        //Set Price to $14
        price = 14.00F;
        if(toppings.size()>1) {
            //Intentional to start at 1 as I don't charge for cheese.
            //Charges for each topping
            for (int i = 1; i < toppings.size(); i++) {
                price += 2.00;
                description += ", " + toppings.get(i);
            }
        }
        //Creates a String of the first letter of each of the topping names and sets the price to $10 + $1 per topping
        String firstLetters = "";
        for(int i = 0; i<toppings.size(); i++){
            firstLetters += toppings.get(i).charAt(0);
        }
        if (firstLetters.toLowerCase().equals("clark")||firstLetters.toLowerCase().equals("cougars")){
            price = 10.0F + firstLetters.length()-1;
        }
    }
    //Sets the price of the Pizza
    public void setPrice(float price) {
        this.price = price;
    }
    //Returns the Price
    public float getPrice(){
        return price;
    }
    //Returns a String rep of Pizza
    public String toString(){
        return "Your Pizza toppings are: " + description + ". Your total price is: $" + price;
    }
}
