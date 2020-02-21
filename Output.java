import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;

public class Output {
    public static Output outputObj = new Output();
    //This method returns a string value depending on which directory the data will be read from
    //1 = ArrayDirectory, 2 = ArrayListDirectory, 3 = HashMapDirectory
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
    //This method is used to write the data from the given directory to a CSV file
    public void fileWriter(String fileName, String dirChoice) throws IOException {
        FileWriter myWriter = new FileWriter(fileName);
        ArrayList<Entry> data = dirToUse(dirChoice);
        //This for loop iterates through each entry and in the ArrayList and line by line writes each entry to the file
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
        //This method writes my performance analysis data to a txt file
        public void performanceAnalysisReport(String fileName) throws IOException {
            FileWriter myWriter = new FileWriter(fileName);
            String[] resultTitles = {"Array: InsertMethod", "ArrayList: InsertMethod", "HashMap: InsertMethod",
                    "Array: LookUpMethod", "ArrayList: LookUpMethod", "HashMap :LookUpMethod",
                    "Array: DeleteSurnameMethod", "ArrayList: DeleteSurnameMethod", "HashMap: DeleteSurnameMethod",
                    "Array: DeleteExtensionMethod", "ArrayList: DeleteExtensionMethod",
                    "HashMap: DeleteExtensionMethod"};
            myWriter.write("PERFORMANCE ANALYSIS REPORT\n");
            myWriter.write("---------------------------\n");
            myWriter.write("                           \n");
            myWriter.write("Each of the methods specified below have been run 1000x for each directory.\n");
            myWriter.write("The data below shows the calculated best, worst and mean " +
                    "execution times in nanoseconds.\n");
            myWriter.write("                           \n");
            long[][] resultsArray = PerformanceAnalysis.performanceAnalysisObj.arrayOfResults();
            for (int i = 0; i < 12 ; i++) {
                long[] testResults = resultsArray[i];
                String value1 = String.format("%-6s",String.valueOf(testResults[0] ));
                String value2 = String.format("%-10s",String.valueOf(testResults[1] ));
                String value3 = String.format("%-10s",String.valueOf(testResults[2] ));
                String resultTitle = String.format("%-35s",String.valueOf(resultTitles[i] ));
                String stringOfReportLine = resultTitle + "Best execution time: " + value1 + "Worst execution time: " + value2 + "Mean execution time: " + value3;
                myWriter.write(stringOfReportLine);
                myWriter.write("\n");
            }
        System.out.println("The performance analysis data has been output to " + fileName + " in the form of a txt file.");
        myWriter.close();
    }


    //This method writes the data from the given directory to an ASCII table
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
            //This pads the strings with empty spaces
            String formattedSurname =  String .format("%-15s", surname1);
            String formattedInitials =  String .format("%-15s", initials1);
            String formattedExtension =  String .format("%-15s", telephoneExtension1);

            String stringOfEntryLine = "|   " + formattedSurname + "   |   " + formattedInitials + "   |   " + formattedExtension + "   |";
            System.out.println(stringOfEntryLine);
        }
        System.out.println("+---------------------+---------------------+---------------------+");
    }
}
