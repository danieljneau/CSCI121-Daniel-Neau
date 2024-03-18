//Import the necessary Methods
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.text.DecimalFormat;
//Create the Class
public class GUI extends JFrame implements ActionListener {
    //Set the different elements
    private static final DecimalFormat df = new DecimalFormat("0.00");
    ShoppingCart cart = new ShoppingCart();
    JLabel intro = new JLabel("Hello, welcome to the Cougar General Store (CGS):");
    JLabel question = new JLabel("Please enter the name of a pint of berries you would like to buy (price per 100 berries ~1pt)");
    String[] t = {"Acai 3.00", "Blueberries 4.00", "Cranberry 1.75", "Dewberries 7", "Elderberry 4.50", "Farkleberry 7.00", "Grape 4.00", "Huckleberry 10.00", "Incaberry 4.33", "Juneberry 6.75", "KarondaBerry 25.00", "Lingonberry 3.50 ", "Marionberry 8.00", "Nannyberry 7.50", "Olallieberry 10.00", "Pineberries 4.60", "Quaberries 5.75", "Raspberry 6.45", "Strawberry 3.65", "Tayberry 7.80", "UgniBerries 9.50", "Wintergreen 1.50", "XiguaBerries 9.75", "Yumberies 5.00", "ZinfandelBerries 7.80"};
    JComboBox item = new JComboBox(t);
    JLabel number = new JLabel("Please enter the quantity (number of pints) of the selected berries you want");
    String[] n = {"1","2","3","4","5","6","7","8","9","10"};
    JComboBox items = new JComboBox(n);
    String[] forItem;
    JButton end =  new JButton("Proceed to Checkout");
    JLabel checkout = new JLabel();
    JLabel coupon = new JLabel();
    JLabel fin = new JLabel("Please come into the store to pay.");
    //Sets Creates the class and format and add the elements to the frame
    public GUI() {
        super("Your Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        item.addActionListener(this);
        items.addActionListener(this);
        end.addActionListener(this);
        add(intro);
        add(question);
        add(item);
        add(number);
        add(items);
        add(end);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Checks If the source is each combobox or the button
        //If the Combo Box with the Items it formats the selection to a String Array so the computer can use it as an Item
        if(e.getSource() == item) {
            forItem = item.getSelectedItem().toString().split(" ");
        }
        //If the source is the combobox with numbers in it the computer takes this and forItem and turns it to an ItemOrder
        else if (e.getSource() == items) {
            cart.addToCart(new ItemOrder(new Item(Float.parseFloat(forItem[1]), forItem[0]), Integer.parseInt(Objects.requireNonNull(items.getSelectedItem()).toString())));
        }
        //If the source is the button the program Checks Out the users cart.
        else if(e.getSource() == end){
            ItemOrder highest = cart.getList().get(0);
            ItemOrder cheapest = cart.getList().get(0);
            for(int i = 1; i< cart.getList().size();i++){
                System.out.println(i);
                if(highest.getOrderPrice() <= cart.getList().get(i).getOrderPrice()){
                    highest = cart.getList().get(i);
                } else if (cheapest.getOrderPrice() >= cart.getList().get(i).getOrderPrice()) {
                    cheapest = cart.getList().get(i);
                }
            }
            //Adds the Coupons and checks out
            float TPC = cart.applyTotalPercentageCoupon(5);
            float IPC  = cart.applyItemPercCoupon(10, cheapest);
            float BGF = cart.applyBGFCoupon(2, highest, 1, cheapest);
            checkout.setText("Your Total is: $" +df.format(cart.getTotalPrice()) + "Your Coupon options are:");
            coupon.setText("Total 5% coupon, total = $" + df.format(TPC) + ", 10% Item percentage Coupon, total = $" + df.format(IPC) + ", or a Buy 2 of your most expensive item get one of your cheapest item free Total = $" + df.format(BGF));
            add(checkout);
            add(coupon);
            add(fin);
            revalidate();
        }
    }

    public static void main(String[] args) {
        //Sets the frame size and runs the GUI
        final int FRAME_WIDTH = 1000;
        final int FRAME_HEIGHT = 300;
        GUI frame = new GUI();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }
}
