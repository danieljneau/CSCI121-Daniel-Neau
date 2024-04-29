//Imports necessary classes
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Tree {
    //Sets private node
    private static Node root;
    private static Scanner s;

    static {//Trys to scan the text file
        try {
            s = new Scanner(new File("./src/Questions.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Tree(){//Creates a new Tree
        root = null;
    }

    public void setRoot(Node root) {//Setter method for the tree
        this.root = root;
    }

    public static void buildTree(){//Builds the tree
        root = new Node();
        root.buildFrom();
    }

    public static String getFromScan(){//Collects each line as the scanner
        return s.nextLine();
    }

    public static String readFromFile() throws Exception {//Reads the text file
        String content = Files.readString(Path.of("./src/Questions.txt"), StandardCharsets.UTF_8);
        return content;
    }

    public static void main(String[] args) {//Runs the code and counts the number of questions the cpu asks
        Scanner scan = new Scanner(System.in);
        buildTree();
        int count = 0;
        while (true){
            count++;
            root.ask();
            System.out.println("Do you want to play again?");
            String r = scan.nextLine();
            r = r.substring(0, 1);
            if (r.equalsIgnoreCase("n")) {
                break;
            }
        }
        String fileName = "./src/Questions.txt";
        String contentToWrite = root.writeToList();
        try {
            FileWriter fileWriter = new FileWriter(fileName); // true parameter enables appending
            fileWriter.write(contentToWrite);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file, " + fileName);
            e.printStackTrace();
        }
        if(count>1)//Creativity (Counts the number of total questions asked.
            System.out.println("I got it in " + count);
    }
}
