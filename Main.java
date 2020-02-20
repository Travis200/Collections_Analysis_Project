import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Input.inputObj.userInterface();
        Output.outputObj.fileWriter("write_data.csv");
        HashMapDirectory.hashMapDirectoryObj.updateExtensionUsingName("Bob", "88888");
        System.out.println(HashMapDirectory.telExtensionHashMap.get("88888").getTelephoneExtension());
        System.out.println(HashMapDirectory.surnameHashMap.get("Bob").getTelephoneExtension());
        //ArrayDirectory.arrayDirectoryObj.deleteEntryUsingName("Peter");
        //Output.outputObj.tableWriter();

        //Entry entry1 = new Entry("Smith", "T.S.H", "11111");
        //ArrayDirectory.obj1.insertEntry(entry1);
        //System.out.println(ArrayListDirectory.obj2.lookupExtension("Whatsize"));
        //Output.outputObj.tableWriter();
    }
}
