import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory {
    public static ArrayDirectory arrayDirectoryObj = new ArrayDirectory();
    public static Entry[] directoryEntries = new Entry[0];

    @Override
    public void insertEntry(Entry entry) {
        String isInArray = lookupExtension(entry.getSurname());
        if (isInArray != null) {
            return;
        }
            Entry[] tempArray = new Entry[directoryEntries.length + 1];
            System.arraycopy(directoryEntries, 0, tempArray, 0, directoryEntries.length);
            tempArray[directoryEntries.length] = entry;
            directoryEntries = tempArray;
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        Entry[] tempArray = new Entry[directoryEntries.length-1];
        int counter = 0;
        for (int i = 0; i < directoryEntries.length; i++) {
            if (!(directoryEntries[i].getSurname().equals(surname))) {
                tempArray[counter] = directoryEntries[i];
                counter += 1;
            }
        }
        directoryEntries = tempArray;
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        Entry[] tempArray = new Entry[directoryEntries.length-1];
        int counter = 0;
        for (int i = 0; i < directoryEntries.length; i++) {
            if (!(directoryEntries[i].getTelephoneExtension().equals(number))) {
                tempArray[counter] = directoryEntries[i];
                counter += 1;
            }
        }
        directoryEntries = tempArray;
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for (Entry directoryEntry : directoryEntries) {
            if (directoryEntry.getSurname().equals(surname)) {
                directoryEntry.setTelephoneExtension(newNumber);
            }
        }
    }

    @Override
    public String lookupExtension(String surname) {
        String result = null;
        for (int i = 0; i < directoryEntries.length; i++) {
            if (directoryEntries[i].getSurname().equals(surname)) {
                result = directoryEntries[i].getTelephoneExtension();
            }
        }
        return result;
    }

    @Override
    public List<Entry> toArrayList() {
        ArrayList<Entry> arrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        return arrayList;
    }

}
