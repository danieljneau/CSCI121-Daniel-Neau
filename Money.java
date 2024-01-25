import java.util.Scanner;
public class Money{
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Hello welcome to my Change Calculator");
        System.out.println("To start please enter a dollar amount:");
        double money = scan1.nextDouble();//Takes user input saves it to money
        int change = (int)(money * 100);//Converts that to whole number of cents the user imputed
        System.out.println("This Change Calculator can give the change as the least # of coins or the least value of coins");
        System.out.println("If you want the change as the least # of coins type num, if you want the change as the least weight type weight");
        String op = scan2.nextLine();//Scans to see if the user wants the least number of coins or the least amount of weight
        //Creates the variables for the coins
        int dollar = 0;
        int half = 0;
        int quart = 0;
        int dime = 0;
        int nick = 0;
        int pen = 0;
        if(op.equalsIgnoreCase("num")){
            //If the user specifies they want the least # of coins the computer calculates the number of coins by dividing the amount of change by the value of the coin it is trying to find
            dollar = change/100;
            change = change%100;
            half = change/50;
            change = change%50;
            quart = change/25;
            change = change%25;
            dime = change/10;
            change = change%10;
            nick = change/5;
            change = change%5;
            pen = change;
        }
        else if(op.equalsIgnoreCase("weight")) {
            //If the user specifies they want the least weight the computer first calculates the number of dollar coins as the coin is the lightest way to get to a dollar
            dollar = change/100;
            change = change%100;
            //The computer then calculates half dollars (it is coded this way because this is the easiest way for it to be checked as a half dollar coin weighs the same as 2 quarters and 5 dimes
            half = change/50;
            change = change%50;
            //next the computer will calculate the number of pennies that will be needed to get the rest of the change to a multiple of 5
            while(!(change%5==0)){
                pen ++;
                change --;
            }
            //The computer then needs to divvy up the rest of the coins to get the least weight, to do this the computer checks to see if the value of the remaining change is a multiple of 10 in which case dimes would be better than the least coins method
            if (change%10 == 0){
                dime = change/10;
            }
            //If the value is not a multiple of 10 then the normal least coins method results in the least weight
            else{
                quart = change/25;
                change = change%25;
                dime = change/10;
                change = change%10;
                nick = change/5;
            }
        }
        else{
            System.out.println("INVALID ENTRY PLEASE RESTART");
        }
        //Calculates the weight of the coins then prints out the coins needed and their weight
        double weight = (2.5*pen)+(5*nick)+(2.268*dime)+(5.67*quart)+(11.34*half)+(8.1*dollar);
        System.out.println(("You will need:\n" + dollar + " dollar coins\n" + half + " half dollar coins\n" + quart + " quarters\n" + dime + " dimes\n"+ nick + " nickels\n" + pen + " pennies"));
        System.out.println("Your weight will be:\n" + weight + " grams");
    }
}
