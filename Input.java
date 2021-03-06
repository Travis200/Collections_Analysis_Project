import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Input {
    public static Input inputObj = new Input();
    public static String userChoice2 = null;

    //This method reads the data from a CSV file and takes the file location and the directory to use as parameters
    //for dirChoice: 1 = ArrayDirectory, 2 = ArrayListDirectory, 3 = HashMapDirectory
    public void readFile(String fileLoc, String dirChoice) throws IOException {
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader(fileLoc));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            Entry fileLine = new Entry(data[0], data[1], data[2]);
            directoryEntryInsert(dirChoice, fileLine);
        }
        csvReader.close();
        }
        //This method creates a user interface and takes the CSV file location which can be read as a parameter
        public void userInterface(String fileLoc) throws IOException {
            Scanner scannerObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Would your like to use a CSV file (1) or Manually input entries (2)?");
            System.out.print("Input option 1 or 2: ");
            String userChoice1 = scannerObj.nextLine().trim();  // Read user input
            while (!((userChoice1.equals("1")) || (userChoice1.equals("2")))) {
                System.out.print("Invalid input, please input 1 or 2: ");
                userChoice1 = scannerObj.nextLine().trim();
            }
            System.out.println("Would like to use the ArrayDirectory (1), ArrayListDirectory (2)," +
                    " or HashMapDirectory (3) to process the entries");
            System.out.print("Input option 1 or 2 or 3: ");
            userChoice2 = scannerObj.nextLine().trim();
            while (!((userChoice2.equals("1")) || (userChoice2.equals("2")) || (userChoice2.equals("3")))) {
                System.out.print("Invalid input, please input 1 or 2 or 3: ");
                userChoice2 = scannerObj.nextLine().trim();
            }
            if (userChoice1.equals("1")) {
                System.out.println("CSV file will be used to input entries into the directory");
                readFile(fileLoc, userChoice2);
            }
            else {
                System.out.println("You have chosen to input entries into the directory manually");
                System.out.print("Would you like to add an entry? (Y = yes, N = no)? ");
                String userChoice3 = scannerObj.nextLine().trim().toUpperCase();
                while (!((userChoice3.equals("Y")) || (userChoice3.equals("N")))) {
                    System.out.print("Invalid input, please input Y or N: ");
                    userChoice3 = scannerObj.nextLine().trim().toUpperCase();
            }
                while (!(userChoice3.equals("N"))){
                    if (userChoice3.equals("Y")) {
                        System.out.println("Store user entries here");
                        System.out.print("Surname: ");
                        String surname = scannerObj.nextLine().trim();
                        System.out.print("Initials: ");
                        String initials = scannerObj.nextLine().trim().toUpperCase();
                        System.out.print("Telephone Extension: ");
                        String telExt = scannerObj.nextLine().trim();
                        while(telExt.length() != 5) {
                            System.out.println("Telephone extension must be exactly 5 numbers long");
                            System.out.print("Please enter the telephone extension again: ");
                            telExt = scannerObj.nextLine().trim();
                        }
                        Entry entry1 = new Entry(surname, initials, telExt);
                        directoryEntryInsert(userChoice2, entry1);
                        System.out.print("Would you like to add another entry? (Y = yes, N = no)? ");
                        userChoice3 = scannerObj.nextLine().trim().toUpperCase();
                    }
                    else {
                        System.out.print("Invalid input, please input Y or N: ");
                        userChoice2 = scannerObj.nextLine().trim().toUpperCase();
                    }
                }
                    System.out.println("Ok, no more entries will be added.");

                }
        }
        //This method inserts the data into users chosen directory
        public void directoryEntryInsert(String userChoice2, Entry entryLine){
        if (userChoice2.equals("1")){
            ArrayDirectory.arrayDirectoryObj.insertEntry(entryLine);

        }
        else if (userChoice2.equals("2")){
            ArrayListDirectory.arrayListDirectoryObj.insertEntry(entryLine);
        }
        else {
            HashMapDirectory.hashMapDirectoryObj.insertEntry(entryLine);
        }
        }

}



