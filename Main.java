import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //This runs the user interface and and takes the location of the CSV file which can be read as a parameter
        Input.inputObj.userInterface("test_data.csv");


        String sameDirAsInput = Input.userChoice2;
        //This outputs the data from a given directory the user inputted to a CSV file and as an ASCII table
        Output.outputObj.fileWriter("write_data.csv", sameDirAsInput);
        Output.outputObj.tableWriter(sameDirAsInput);

        //This runs and writes my analysis report to a a given txt file
        Output.outputObj.performanceAnalysisReport("performance_report.txt");

    }
}
