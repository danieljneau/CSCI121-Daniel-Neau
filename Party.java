public class Party {
    private int numGuests;
    public void setNumGuests(int num){
        numGuests = num;
    }
    public int getNumGuests(){
        return numGuests;
    }

    public void displayInvitation(){
        System.out.println("\n\n\n");
        System.out.println("The Party has " + numGuests + " guests");
        System.out.println("Please come to my party");
    }
}
