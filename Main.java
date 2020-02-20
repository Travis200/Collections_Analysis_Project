import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Input.inputObj.userInterface();
        Output.outputObj.fileWriter("write_data.csv");
        ArrayDirectory.arrayDirectoryObj.updateExtensionUsingName("Bob", "55555");
        //ArrayDirectory.arrayDirectoryObj.deleteEntryUsingName("Peter");
        Output.outputObj.tableWriter();

        //Entry entry1 = new Entry("Smith", "T.S.H", "11111");
        //ArrayDirectory.obj1.insertEntry(entry1);
        //System.out.println(ArrayListDirectory.obj2.lookupExtension("Whatsize"));
        //Output.outputObj.tableWriter();
    }
}
