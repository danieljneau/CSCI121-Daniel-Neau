//Import necessary class
import java.util.ArrayList;
public class BloodBank {
    //Set necessary variables
    private ArrayList<BloodData> bank;
    private String name;

    //Set default constructor which gives the bank the name of "Default Bank" and sets the bank to have one of each blood type in it
    public BloodBank(){
        name = "Default Bank";
        bank =new ArrayList<BloodData>();
        bank.add(new BloodData());
        bank.add(new BloodData("O", "+"));
        bank.add(new BloodData("A", "-"));
        bank.add(new BloodData("A", "+"));
        bank.add(new BloodData("B", "-"));
        bank.add(new BloodData("B", "+"));
        bank.add(new BloodData("AB", "-"));
        bank.add(new BloodData("AB", "+"));
    }

    //Constructor creates a bank with the name of "name" and the first Blood Type
    public BloodBank(String name, BloodData data){
        this.name = name;
        bank = new ArrayList<BloodData>();
        bank.add(data);
    }

    //Adds the specified Blood Type to the bank
    public void addToBank(BloodData d){
        bank.add(d);
    }

    //Removes the first instance of the specified blood type from the bank
    public void removeFromBank(BloodData t){
        boolean removed = false;
        for(int i = 0; i< bank.size(); i++){
            if(bank.get(i).equals(t)){
                bank.remove(i);
                break;
            }
        }
        //If nothing removed prints an error message
        if(removed){
            System.out.println("Can not remove " + t.toString() + " from " + name);
        }
    }

    //Default get and set methods
    public ArrayList<BloodData> getBank() {
        return bank;
    }

    public void setBank(ArrayList<BloodData> bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //toString method displays the banks being held
    public String toString() {
        return bank.toString();
    }
}
