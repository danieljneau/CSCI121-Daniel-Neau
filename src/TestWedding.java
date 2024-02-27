//Imports necessary files
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestWedding extends JFrame implements ActionListener{
    //Create all parts of the GUI
    JLabel intro = new JLabel("Hello welcome to the Wedding Planer:");
    JLabel step1 = new JLabel("Please enter the First and Last name of the Groom and Bride in that order (Max 50 Characters):");
    JTextField name1 = new JTextField(50);
    JLabel and = new JLabel(" & ");
    JTextField name2 = new JTextField(50);
    JLabel dateQ = new JLabel("What date do you want the Wedding?");
    JTextField date = new JTextField(30);
    JLabel location = new JLabel("What location do you want your Wedding");
    Location Barn = new Location("Barn", 100);
    Location Church = new Location("Church", 50);
    Location Beach = new Location("Beach", 1000);
    private Location [] locals;
    JLabel guests = new JLabel("How many guests");
    String [] guest = {"0-50", "51-100", ">100"};
    JComboBox numGuests = new JComboBox(guest);
    JComboBox loc = new JComboBox();
    JLabel out = new JLabel();
    public TestWedding(){
        //Set necessary formats and adding the parts of the GUI to the frame
        super("Your Wedding");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        Font standard = new Font("Arial",Font.PLAIN,20);
        intro.setFont(new Font("Arial", Font.BOLD, 50));
        name1.addActionListener(this);
        name2.addActionListener(this);
        date.addActionListener(this);
        numGuests.addActionListener(this);
        step1.setFont(standard);
        dateQ.setFont(standard);
        guests.setFont(standard);
        location.setFont(standard);
        add(intro);
        add(step1);
        add(name1);
        add(and);
        add(name2);
        add(dateQ);
        add(date);
        add(guests);
        add(numGuests);
        add(location);
    }
    //Check the number of guests and limits the possibilities of location **CREATIVE**
    public void getnumGuests(){
        if (numGuests.getSelectedItem().equals("0-50")){
            locals = new Location[]{Church, Barn, Beach};
        } else if (numGuests.getSelectedItem().equals("51-100")){
            locals = new Location[]{Barn, Beach};
        }
        else{
            locals = new Location[] {Beach};
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Create the parts of a Wedding when a dropdown is interacted with
        String[] groomName = name1.getText().split(" ");
        String[] brideName = name2.getText().split(" ");
        Person groomPerson = new Person(groomName[0],groomName[1]);
        Person bridePerson = new Person(brideName[0],brideName[1]);
        Couple couple = new Couple(groomPerson, bridePerson);
        String dateOfWedding = date.getText();
        getnumGuests();
        remove(loc);
        loc = new JComboBox(locals);
        add(loc);
        Wedding wed = new Wedding(date.getText(), couple, (Location) loc.getSelectedItem());
        out.setText(wed.toString());
        out.setFont(new Font("Arial", Font.BOLD, 30));
        add(out);
    }
//Creates the Frame and sets the size;
    public static void main(String[] args){
        final int FRAME_WIDTH = 1100;
        final int FRAME_HEIGHT = 300;
        TestWedding frame = new TestWedding();
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);
    }
}

