import java.util.Scanner;//Import Scanner class

public class Node {
    //Set private variables
    private Scanner scan = new Scanner(System.in);
    private Node yes = null;
    private Node no = null;
    private String text;
    //Set a default constructor
    public Node(){
        text = null;
    }

    public Node(String text){//Set a constructor that sets the text
        this.text = text;
    }

     public boolean isLeaf(){//Checks if the node has children
        if(yes != null){
            return false;
        }
        return true;
     }

     public void ask(){//Sets the node to ask what it contains
        if(isLeaf()){ //If the node is a leaf
            System.out.println("Is the thing a " + text + "?");
            String r = scan.nextLine();
            r = r.substring(0,1);
            if(r.equalsIgnoreCase("y")){//If response is yes has the code say it gets.
                System.out.println("Yay! I got it.");
            }
            else if(r.equalsIgnoreCase("n")){//If response is no gets the item and a differential question.
                System.out.println("What was your thing?");
                String thing = scan.nextLine();
                System.out.println("What question does " + thing + " satisfy but " + text + " does not?");
                String question = scan.nextLine();
                yes = new Node(thing);
                no = new Node(text);
                text = question;
            }
        }
        else{//If the node is not a leaf asks what is held.
            System.out.println(text);
            String r = scan.nextLine();
            r = r.substring(0,1);
            if(r.equalsIgnoreCase("y")){//If user responds yes asks the yes node
                yes.ask();
            }
            else{//If user responds no asks the no question
                no.ask();
            }
        }

     }

     public String writeToList(){//Writes the Node to a string
        if(isLeaf()){//If it is a leaf adds a # to the beginning of the response.
            return "#" + text;
        }
        else{//
            return text + "\n" + yes.writeToList() + "\n" + no.writeToList();
        }
     }

    public void buildFrom(){//Builds the node from the text file
        String u = Tree.getFromScan();
        if(u.substring(0,1).equalsIgnoreCase("#")){//If the line begins with a # then just adds the text to the node.
            text = u.substring(1);
        }
        else{//If the line does not have a # builds the next node from the Question
            text = u;
            yes = new Node();
            yes.buildFrom();
            no = new Node();
            no.buildFrom();
        }
    }

    //Getter and Setter methods
    public Node getNo() {
        return no;
    }

    public Node getYes() {
        return yes;
    }

    public void setNo(String t) {
        no = new Node();
        no.setText(t);
    }

    public void setYes(String t) {
        yes = new Node();
        yes.setText(t);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
