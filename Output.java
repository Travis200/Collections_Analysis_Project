import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Output {
    public static Output outputObj = new Output();

    public ArrayList<Entry> dirToUse (String dirChoice) {
        ArrayList<Entry> data = null;
        if(dirChoice.equals("1")) {
            data = (ArrayList<Entry>) ArrayDirectory.arrayDirectoryObj.toArrayList();
        }
        else if (dirChoice.equals("2")){
            data = (ArrayList<Entry>) ArrayListDirectory.arrayListDirectoryObj.toArrayList();
        }
        else if (dirChoice.equals("3")){
            data = (ArrayList<Entry>) HashMapDirectory.hashMapDirectoryObj.toArrayList();
        }
        return  data;
    }

    public void fileWriter(String fileName, String dirChoice) throws IOException {
        FileWriter myWriter = new FileWriter(fileName);
        ArrayList<Entry> data = dirToUse(dirChoice);
        for (int i = 0; i < data.size(); i++) {
            String surname1 = data.get(i).getSurname();
            String initials1 = data.get(i).getInitials();
            String telephoneExtension1 = data.get(i).getTelephoneExtension();
            String stringOfEntryLine = surname1 + "," + initials1 + "," + telephoneExtension1;
            myWriter.write(stringOfEntryLine);
            myWriter.write("\n");
        }
        System.out.println("The data has been output to " + fileName + " in the form of a CSV file.");
        myWriter.close();
    }

    public void tableWriter(String dirChoice) {
        ArrayList<Entry> data = dirToUse(dirChoice);
        System.out.println("This is data returned in an ASCII table:");
        System.out.println("+---------------------+---------------------+---------------------+");
        System.out.println("|   Surname           |   Initials          |  Extension          |");
        System.out.println("+---------------------+---------------------+---------------------+");
        for (int i = 0; i < data.size(); i++) {
            String surname1 = data.get(i).getSurname();
            String initials1 = data.get(i).getInitials();
            String telephoneExtension1 = data.get(i).getTelephoneExtension();
            String formattedSurname =  String .format("%-15s", surname1);
            String formattedInitials =  String .format("%-15s", initials1);
            String formattedExtension =  String .format("%-15s", telephoneExtension1);

            String stringOfEntryLine = "|   " + formattedSurname + "   |   " + formattedInitials + "   |   " + formattedExtension + "   |";
            System.out.println(stringOfEntryLine);
        }
        System.out.println("+---------------------+---------------------+---------------------+");
    }
}