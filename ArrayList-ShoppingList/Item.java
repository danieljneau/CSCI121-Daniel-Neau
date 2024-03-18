//Create and Set the Class and Variables
public class Item {
    private float price;
    private String name;
    //Initializes the Var
    public Item (float price, String name){
        this.price = price;
        this.name = name;
    }
    //Get Price + Get Name  + toString method
    public float getPrice(){
        return price;
    }

    public String getName(){

        return name;
    }

    public String toString(){
        return name + " $" + price;
    }
}
