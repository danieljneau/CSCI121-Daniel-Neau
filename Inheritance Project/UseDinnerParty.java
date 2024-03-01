import java.util.Scanner;
import java.util.ArrayList;
public class UseDinnerParty {
    public static void main(String args[]){
        int guests;
        ArrayList<String> dinnerOptions = new ArrayList<String>();
        int count;
        String hold = "";
        Party myParty = new Party();
        DinnerParty myDinnerParty = new DinnerParty();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number of Guests");
        guests = scan.nextInt();
        myParty.setNumGuests(guests);
        myParty.displayInvitation();
        System.out.println("\nPlease enter the number of guests for the dinner party");
        guests = scan.nextInt();
        myDinnerParty.setNumGuests(guests);
        System.out.println("Enter the food choices you want to have, enter 'end' to end");
        hold = scan.nextLine();
        while (!(hold.equalsIgnoreCase("end"))){
            dinnerOptions.add(hold);
            hold = scan.nextLine();
        }
        if (dinnerOptions.size() == 1){
            System.out.println("Sorry you didn't enter any dinner options");
        }
        else{
            for(int i = 0; i<dinnerOptions.size(); i++){
                count = i+1;
                System.out.println(count + dinnerOptions.get(i));
            }
        }
        if (dinnerOptions.size()!=1) {
            DinnerPartyInvitation invitation = new DinnerPartyInvitation(myDinnerParty, dinnerOptions);
            invitation.invite();
        }
    }
}
