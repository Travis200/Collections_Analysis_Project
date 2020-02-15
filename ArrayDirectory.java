import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory {
    private Entry[] directoryEntries = new Entry[0];

    @Override
    public void insertEntry(Entry entry) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        directoryEntriesArrayList.add(entry);
        this.directoryEntries = new Entry[directoryEntriesArrayList.size()];
        this.directoryEntries = directoryEntriesArrayList.toArray(this.directoryEntries);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                directoryEntriesArrayList.remove(i);
            }
            this.directoryEntries = directoryEntriesArrayList.toArray(this.directoryEntries);

        }

    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            if (directoryEntriesArrayList.get(i).getTelephoneExtension().equals(number)) {
                directoryEntriesArrayList.remove(i);
            }
            this.directoryEntries = directoryEntriesArrayList.toArray(this.directoryEntries);
        }
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                //insert Code here for updating extension here
            }
            this.directoryEntries = directoryEntriesArrayList.toArray(this.directoryEntries);
        }
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
