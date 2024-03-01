import java.util.ArrayList;
import java.util.Scanner;
public class DinnerPartyInvitation {
    private DinnerParty dinner;
    private ArrayList<String> options;
    int choice;
    public DinnerPartyInvitation(DinnerParty dp, ArrayList<String> op){
        dinner = dp;
        options = op;
    }
    public void invite(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("The Dinner party has " + dinner.getNumGuests() + " guests");
        System.out.println("Please come to my Party");
        System.out.println("Your dinner options are:");
        for(int i = 1; i<options.size(); i++){
            System.out.print(i + " for " + options.get(i) +", ");
        }
        System.out.println("\nPlease select a Dinner option");
        int select = scan.nextInt();
        System.out.println("You selected " + options.get(select) + " to eat at my dinner party");

    }

}
