//Import the ArrayList
import java.util.ArrayList;
//Create Class and Set Varubles
public class ShoppingCart {
    private float totalPrice;
    private ArrayList<ItemOrder> list = new ArrayList<>();
    public ShoppingCart(){
        totalPrice = 0;
    }
    //Checks if the shopper bought enough for the bulk discount to take effect
    public float checkForDiscount(ItemOrder i){
        if(i.getQuantity() > 5){
            return (float) (i.getOrderPrice() * .95);
        } else if (i.getQuantity() >10) {
            return (float) (i.getOrderPrice() * .95);
        } else{
            return i.getOrderPrice();
        }
    }
    //Set Get Methods
    public float getTotalPrice(){
        return totalPrice;
    }
    public ArrayList<ItemOrder> getList(){
        return list;
    }
    //Adds the item to the cart and adds its price
    public void addToCart(ItemOrder io){
        list.add(io);
        totalPrice += checkForDiscount(io);
    }
    //Sets the different type of coupons
    public float applyTotalPercentageCoupon(int perc){
        return totalPrice * (100-perc)/100;
    }
    public float applyItemPercCoupon(int perc, ItemOrder p){
        float holdPrice = totalPrice;
        holdPrice -= checkForDiscount(p);
        holdPrice += p.getOrderPrice() * (100-perc)/100;
        return holdPrice;
    }
    public float applyBGFCoupon(int buy, ItemOrder b, int get, ItemOrder g){
        float holdPrice = totalPrice;
        holdPrice -= checkForDiscount(b);
        holdPrice -= checkForDiscount(g);
        int count = 0;
        for(int i = b.getQuantity(); i>=buy; i-=buy){
            count ++;
        }
        holdPrice += b.getOrderPrice();
        int numPay = g.getQuantity() - get;
        if(numPay > 0){
            holdPrice += g.getItem().getPrice() * numPay;
        }
        return  holdPrice;
    }
}
