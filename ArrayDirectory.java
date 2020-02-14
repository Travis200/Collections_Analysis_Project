import java.io.FileReader;
import java.util.List;

public class ArrayDirectory implements Directory {
    Entry[] directoryEntries[0];
    @Override
    public void insertEntry(Entry entry) {

    }

    @Override
    public void deleteEntryUsingName(String surname) {

    }

    @Override
    public void deleteEntryUsingExtension(String number) {

    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {

    }

    @Override
    public String lookupExtension(String surname) {
        return null;
    }

    @Override
    public List<FileReader> toArrayList() {
        return null;
    }



    /*public String[][] directoryCreator() {
        String[][] directory = {{"Higgins", "TSH", "98356" }, {"Waterhouse", "LWW", "86522"}};
        return directory;
    }*/

    public static void main(String[] args) {
        ArrayDirectory obj = new ArrayDirectory();
        Entry myNewEntry= new Entry("Higgins", "TSH", "865352");
        obj.insertEntry(myNewEntry);
    }

}
