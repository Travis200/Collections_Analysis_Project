import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class Output {
    public static Output outputObj = new Output();

    public void fileWriter(String fileName) throws IOException {
        FileWriter myWriter = new FileWriter(fileName);
        List<Entry> data = ArrayListDirectory.obj2.toArrayList();
        for (int i = 0; i < data.size(); i++) {
            String surname1 = data.get(i).getSurname();
            String initials1 = data.get(i).getInitials();
            String telephoneExtension1 = data.get(i).getTelephoneExtension();
            String stringOfEntryLine = surname1 + "," + initials1 + "," + telephoneExtension1;
            //System.out.println(stringOfEntryLine);
            myWriter.write(stringOfEntryLine);
            myWriter.write("\n");
        }
        myWriter.close();
    }

    public void tableWriter() {
        List<Entry> data = ArrayListDirectory.obj2.toArrayList();
        System.out.println("+-------------+--------------+---------------+");
        System.out.println("|   Surname   |   Initials   |     Extension |");
        System.out.println("+-------------+--------------+---------------+");
        for (int i = 0; i < data.size(); i++) {
            String surname1 = data.get(i).getSurname();
            String initials1 = data.get(i).getInitials();
            String telephoneExtension1 = data.get(i).getTelephoneExtension();
            String stringOfEntryLine = "   |   " + surname1 + "   |   " + initials1 + "   |   " + telephoneExtension1 + "   |   ";
            System.out.println(stringOfEntryLine);
        }
        System.out.println("+-------------+--------------+---------------+");
    }
}
