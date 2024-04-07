import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LinkedList l = new LinkedList();
        System.out.println("Hello, please enter your list of Whole Numbers new line seperated type '-1' to quit");
        int i = scan.nextInt();
        while(i !=-1){
            l.insertNode(i);
            i = scan.nextInt();
        }
        l.printList();
        System.out.println("What is the Node before the one you want to remove?");
        int node = scan.nextInt();
        scan.nextLine();
        System.out.println(node);
        System.out.println("Removing the node after " + node);
        l.removeAfter(node);
        l.printList();
        System.out.println("Copy of the LinkedList");
        l.copy().printList();
        System.out.println("What node do you want to remove the duplicates of?");
        int d = scan.nextInt();
        scan.nextLine();
        l.removeDuplicate(d);
        System.out.println("Removed all instances of " + d);
        l.printList();
        System.out.println("The max node is: " + l.max());
        l.printList();
    }
}
