//Imports necessary modules
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
//Implements Action Key and Item Listeners
public class Main extends JFrame implements ActionListener, KeyListener, ItemListener {
    //Creates the parts of the GUI
    JLabel intro = new JLabel("Welcome to Cougar Pizzeria");
    JLabel instructions = new JLabel("Please enter your pizza toppings each on a new line");
    JTextArea toppings = new JTextArea();
    JButton done = new JButton("Done entering Toppings");
    JCheckBox delivery = new JCheckBox("Click For Delivery");
    JTextField address = new JTextField("Please Enter Your Address");
    JLabel total = new JLabel();
    public Main(){
        //Sets a flow layout adds listeners and adds components to frame
        super("Your Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        toppings.addKeyListener(this);
        done.addActionListener(this);
        delivery.addItemListener(this);
        add(intro);
        add(instructions);
        add(toppings);
        add(done);
    }
    @Override
    //When the Button is selected asks if to create a delivery Pizza
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> top= new ArrayList<>(Arrays.asList(toppings.getText().split("\n")));
        add(delivery);
        Pizza p = new Pizza(top);
        total.setText(p.toString());
        add(total);
        revalidate();
    }
    //Creates the frame and runs the GUI
    public static void main(String[] args) {
        final int FRAME_WIDTH = 1000;
        final int FRAME_HEIGHT = 300;
        Main frame = new Main();
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //If the source is where the user enters toppings this stops it from entering more than 10 toppings
        if(e.getSource().equals(toppings)) {
            int r = toppings.getLineCount();
            if (r == 11) {
                toppings.setEditable(false);
            }
        }
        //If the source is where the user enters the address for a delivery this changes the delivery pizza when address is updated
        if(e.getSource().equals(address)){
            ArrayList<String> top= new ArrayList<>(Arrays.asList(toppings.getText().split("\n")));
            String a = address.getText();
            DeliveryPizza dp = new DeliveryPizza(top, a);
            total.setText(dp.toString());
            add(total);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //If the source is where the user enters toppings this stops it from entering more than 10 toppings
        if(e.getSource().equals(toppings)) {
            int r = toppings.getLineCount();
            if (r == 11) {
                toppings.setEditable(false);
            }
        }
        //If the source is where the user enters the address for a delivery this changes the delivery pizza when address is updated
        if(e.getSource().equals(address)){
            ArrayList<String> top= new ArrayList<>(Arrays.asList(toppings.getText().split("\n")));
            String a = address.getText();
            DeliveryPizza dp = new DeliveryPizza(top, a);
            total.setText(dp.toString());
            add(total);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //If the source is where the user enters toppings this stops it from entering more than 10 toppings
        if(e.getSource().equals(toppings)) {
            int r = toppings.getLineCount();
            if (r == 11) {
                toppings.setEditable(false);
            }
        }
        //If the source is where the user enters the address for a delivery this changes the delivery pizza when address is updated
        if(e.getSource().equals(address)){
            ArrayList<String> top= new ArrayList<>(Arrays.asList(toppings.getText().split("\n")));
            String a = address.getText();
            DeliveryPizza dp = new DeliveryPizza(top, a);
            total.setText(dp.toString());
            add(total);
            revalidate();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //If checkbox is checked displays and runs a keyListener for a box where a person can enter their address
        add(address);
        address.addKeyListener(this);
        revalidate();
    }
}
