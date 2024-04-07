//I removed node calls as I am writing this in the LinkedList Class
//Create a linked list class
public class LinkedList {
    private Node head;
    private Node tail;
    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }
        else {
            tail.setNext(n);
            n.setPrev(tail);
        }
        tail = n;
    }

    //Deletes the given node (NOT part of assignment)
    public void deleteNode(Node n){
        if(n.getNext()!= null) {
            if (n.getPrev() != null) {
                n.getPrev().setNext(n.getNext());
                n.getNext().setPrev(n.getPrev());
            } else {
                n.getNext().setPrev(null);
            }
        }
        else
            if(n.getPrev()!= null)
                n.getPrev().setNext(null);
    }

    //Removes the node following the given one Part 1
    public void removeAfter(int n){
        Node current = head;
        //Iterates through the LinkedList
        while(current != null) {
            //If the current node has the key it gets deleted otherwise we move on to the next node
            if(current.getData() == n){
                deleteNode(current.getNext());
            }
            current = current.getNext();
        }
    }

    //Creates a new LinkedList as a deep copy the current LinkedList from the given node Part 2
    public LinkedList copy(){
        //creates an original node that is the given node
        Node original = head;
        LinkedList copied = new LinkedList();
        while(original!= null){
            copied.insertNode(original.getData());
            original = original.getNext();
        }
        return copied;
    }

    //Removes duplicate nodes of the key from the LinkedList past the current node Part 3 (I do not see the need for the node as an argument)(Changed the key to be the data type I want (int))
    public void removeDuplicate(int key){
        //Sets the current node to the head of the LinkedList
        Node current = head;
        //Iterates through the LinkedList
        while(current != null) {
            //If the current node has the key it gets deleted otherwise we move on to the next node
            if(current.getData() == key){
                deleteNode(current);
            }
            current = current.getNext();
        }
    }

    //Finds the max item in the linked list Part 4
    public int max(){
        Node current = head;
        if(current != null){
            int max = current.getData();
            while(current.getNext()!= null){
                current = current.getNext();
                if(max< current.getData())
                    max = current.getData();
            }
            return max;
        }
        else
            return 0;
    }

    //Prints the List
    public void printList(){
        Node current = head;
        System.out.println("========Print Start=============");
        while(current != null){
            int sCurNodeName = current.getData();
            if(current.getPrev() != null)
                System.out.println(current.getPrev().getData()+ " <==> " + sCurNodeName );
            current = current.getNext();

        }
        System.out.println("========Print End=============");
    }
}
