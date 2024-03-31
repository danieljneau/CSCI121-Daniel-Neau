//Necessary imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Instances a default BloodBank and a list to hold all BloodBanks created.
    private static BloodBank dBank = new BloodBank();
    private static ArrayList<BloodBank> bankList= new ArrayList<>(List.of(dBank));

    //Method to add blood to a blood bank
    private static void addBg(){
        //Gets the patient's information from user
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Please enter patient id #");
        short id = scan1.nextShort();
        scan1.nextLine();
        System.out.println("Please enter patient age");
        short age = scan1.nextShort();
        scan1.nextLine();
        System.out.println("Please enter the blood type(O,A,B,AB)");
        String bt = scan1.nextLine();
        System.out.println("Please enter the rh factor (+,-) for the patient");
        String r = scan1.nextLine();
        //Creates a new Patient with specified inputs
        Patient p = new Patient(id, age, bt, r);
        //Converts the list of Blood Banks to a string
        String bl = "";
        for(BloodBank bloodBank: bankList){
            bl+= bloodBank.getName() + ", ";
        }
        System.out.println("The available banks are: " + bl);
        //Asks the user for which bank they want to add the patient's blood to
        System.out.println("type the name of the bank you want to add the blood to or type 'new' to create a new Blood bank");
        String n = scan1.nextLine();
        //If the bank the user selects is in the bankList the blood gets added to that bank
        boolean added = false;
        for(BloodBank bloodBank : bankList) {
            if(bloodBank.getName().equals(n)){
               bloodBank.addToBank(p.getBlood());
               added = true;
            }
        }
        //If the bank the user inputs does not exist prompts the user to create a new bank
        if(!added){
            System.out.println("Please enter a name for this new bank");
            String name = scan1.nextLine();
            bankList.add(new BloodBank(name, p.getBlood()));
        }
    }

    //Method to remove blood from a bank
    private static void out(){
        Scanner scan2 = new Scanner(System.in);
        //Displays the list of banks in bankList
        String bl = "";
        for(BloodBank bloodBank: bankList){
            bl+= bloodBank.getName() + ", ";
        }
        System.out.println("The available banks are: " + bl);
        //Asks the user for the bank they want to remove blood from
        System.out.println("Enter the name of the bank you would like to withdraw the blood from");
        String n = scan2.nextLine();
        //If the bank exists sets obtained to true
        BloodBank b = dBank;
        boolean obtained = false;
        for(BloodBank bloodBank : bankList){
            if(bloodBank.getName().equals(n)){
                b = bloodBank;
                obtained = true;
            }
        }
        //If bank does not exist, informs the user
        if(!obtained){
            System.out.println("Sorry that bank does not exist");
        }
        //If the bank exists asks user which blood they want to remove and removes that blood
        else{
            System.out.println("Bank " + b.getName() + " contains " + b.toString());
            System.out.println("What is the blood type (letter + rh factor (+, -) seperated by a space) you want to remove");
            String  t = scan2.nextLine();
            String[] t2 = t.split(" ");
            b.removeFromBank(new BloodData(t2[0], t2[1]));
        }
    }
    //Main method
    public static void main(String[] Args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Blood Bank");
        //Lets the user continue adding subtracting or viewing blood in the banks until the user types "quit"
        String choice = "";
        while (true) {
            //Asks the user if they want to add, remove, or view blood, or if they want to quit and executes the necessary method.
            System.out.println("To add blood to a bloodBank type 'add'; To withdraw blood type 'out'; To view a blood bank type 'view'. To quit type 'quit'.");
            choice = scan.nextLine();
            String e = "";
            if (choice.equalsIgnoreCase("add")) {
                e = "";
                while (!e.equalsIgnoreCase("end")) {
                    addBg();
                    System.out.println("To end type 'end'. To continue to add donors type 'cont'");
                    e = scan.nextLine();
                }
            } else if (choice.equalsIgnoreCase("out")) {
                e = "";
                while (!e.equalsIgnoreCase("end")) {
                    out();
                    System.out.println("To end type 'end' to continue to remove blood type 'cont'");
                    e = scan.nextLine();
                }
            } else if (choice.equalsIgnoreCase("view")) {
                //If the user selects view the computer displays the bank the user wants to see
                String bl = "";
                for(BloodBank bloodBank: bankList){
                    bl+= bloodBank.getName() + ", ";
                }
                System.out.println("The blood banks we have are: " + bl + "\nWhich bank do you want to view");
                String c = scan.nextLine();
                BloodBank b = dBank;
                for(BloodBank bloodBank: bankList){
                    if(bloodBank.getName().equalsIgnoreCase(c)){
                        b = bloodBank;
                        System.out.println("Bank "+ c + " has these blood types in it: " + b.toString());
                    }
                }
            } else if (choice.equalsIgnoreCase("quit")) {
                //Exits program
                break;
            } else{
                //Informs user and exits the program if they type something other than "add", "out", "view", or "quit"
                System.out.println("INVALID COMMAND TRY AGAIN");
            }
        }
    }
}
