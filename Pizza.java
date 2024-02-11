import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.text.DecimalFormat;

public class Pizza extends JFrame implements ActionListener {
    double price = 0.00;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    JLabel intro = new JLabel("Hello, welcome to Big Y Pizza, please place your order:");
    JLabel question = new JLabel("Please select your pizza size: Small = $5, Medium = $10, Large = $15, XL = $20");
    String[] s = {"Small", "Medium", "Large", "XL"};
    JLabel toppingprice = new JLabel("");
    JComboBox size = new JComboBox(s);
    JLabel top = new JLabel("Select up to 3 toppings, Price per topping $0.50 (3 for $1.25):");
    String[] t = {"None", "Extra Cheese", "Peperoni", "Sausage", "Bacon", "Mushrooms", "Onion", "Black Olive", "Bell Pepper", "Pineapple", "Spinach"};
    JComboBox topping1= new JComboBox<>(t);
    JComboBox topping2 = new JComboBox(t);
    JComboBox topping3 = new JComboBox(t);
    String[] tp = {"20%", "15%", "25%", "Other Amount"};
    JComboBox tip = new JComboBox(tp);
    JLabel tipP = new JLabel("Please enter tip amount");
    JLabel otherAmounta = new JLabel("Please enter the $ amount (in the form of x.xx) you would like to tip:");
    JLabel otherAmountb = new JLabel("(Only applies if you have 'Other Amount' selected)");
    JTextField tipAmount = new JTextField(4);
    JLabel p = new JLabel();
    public Pizza() {
        super("Your Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        size.addActionListener(this);
        topping1.addActionListener(this);
        topping2.addActionListener(this);
        topping3.addActionListener(this);
        tip.addActionListener(this);
        Font basic = new Font("Arial", Font.PLAIN, 20);
        intro.setFont(new Font("Arial", Font.ITALIC,30));
        question.setFont(basic);
        top.setFont(basic);
        toppingprice.setFont(basic);
        tipP.setFont(basic);
        otherAmounta.setFont(basic);
        otherAmountb.setFont(basic);
        p.setFont(new Font("Title", Font.BOLD, 30));
        add(intro);
        add(question);
        add(size);
        add(top);
        add(topping1);
        add(topping2);
        add(topping3);
        add(tipP);
        add(tip);
    }
    public void setPriceSize(String s1){
        if(s1.equals("Small")){
            price = 5.00F;
        } else if (s1.equals("Medium")) {
            price = 10.00F;
        } else if (s1.equals("Large")) {
            price = 15.00F;
        } else if (s1.equals("XL")) {
            price = 20.00F;
        }
    }
    public void setPriceTop(String t1, String t2, String t3){
        //If customer ordered 3 non extra cheese toppings adds $1.25 to price
        if((!t1.equals("None") && !(t1.equals("Extra Cheese"))) && (!t2.equals("None") && !t2.equals("Extra Cheese")
        ) && (!t3.equals("None") && !t3.equals("Extra Cheese"))){
            price += 1.25F;
        }
        //Checks and changes price if previous was false
        else {
            if (!t1.equals("None") && !t1.equals("Extra Cheese")) {
                price += .50F;
            }
            if (!t2.equals("None") && !t2.equals("Extra Cheese")) {
                price += .50F;
            }
            if (!t3.equals("None") && !t3.equals("Extra Cheese")) {
                price += .50F;
            }
        }

    }

    public void setTip(String tp){
        if (tp.equals("20%")){
            price *= 1.2;
        }
        else if (tp.equals("15%")) {
            price *= 1.15;
        }
        else if (tp.equals("25%")) {
            price *= 1.25;
        }
        else if(tp.equals("Other Amount")){
            add(otherAmounta);
            add(otherAmountb);
            add(tipAmount);
            float tipA = Float.parseFloat(tipAmount.getText());
            price += tipA;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = Objects.requireNonNull(size.getSelectedItem()).toString();
        setPriceSize(s1);
        String top1 = Objects.requireNonNull(topping1.getSelectedItem()).toString();
        String top2 = Objects.requireNonNull(topping2.getSelectedItem()).toString();
        String top3 = Objects.requireNonNull(topping3.getSelectedItem()).toString();
        setPriceTop(top1,top2,top3);
        String t = Objects.requireNonNull(tip.getSelectedItem()).toString();
        setTip(t);
        p.setText("Total Due = $" + df.format(price));
        add(p);
    }

    public static void main(String[] args) {
        final int FRAME_WIDTH = 1000;
        final int FRAME_HEIGHT = 300;
        Pizza frame = new Pizza();
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);
    }
}