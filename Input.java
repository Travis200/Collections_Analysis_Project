import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public static ArrayDirectory obj1 = new ArrayDirectory();
    public static Input obj2 = new Input();
    public void readFile() throws IOException {
        ArrayList<Entry> fileDataArrayList = new ArrayList<Entry>();
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader("test_data_small.csv"));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            Entry fileLine = new Entry(data[0], data[1], data[2]);
            //System.out.println(fileLine);
            obj1.insertEntry(fileLine);
        }
        csvReader.close();
        }
        public void userInterface() {
            Scanner scannerObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Would your like to use a CSV file (1) or Manually input entries(2)?");
            System.out.print("Input option 1 or 2: ");
            String userChoice1 = scannerObj.nextLine().trim();  // Read user input
            while (!((userChoice1.equals("1")) || (userChoice1.equals("2")))) {
                System.out.print("Invalid input, please input 1 or 2: ");
                userChoice1 = scannerObj.nextLine().trim();
            }
            if (userChoice1.equals("1")) {
                System.out.println("CSV file");
            } else {
                System.out.println("Manual Entries");
            }
        }
        public static void main (String[]args) throws IOException {
                obj2.readFile();
                obj1.deleteEntryUsingName("Mayow");
                System.out.println(obj1.toArrayList());
                //obj2.userInterface();
                }
}



