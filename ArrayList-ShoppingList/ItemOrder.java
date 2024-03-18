public class ItemOrder{
    //Set Variables
    private int quantity;
    private Item item;
    private float orderPrice;
    //Initialize the Class
    public ItemOrder(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
        orderPrice =(item.getPrice() * quantity);
    }
    //Get Methods
    public Item getItem(){
        return item;
    }
    public  int getQuantity(){
        return quantity;
    }
    public float getOrderPrice(){
        return orderPrice;
    }

    @Override
    //Resets Item's toString Method
    public String toString() {
        return item.toString() + " Quantity: " + quantity + " Total Price = $" + orderPrice;
    }
}
