import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory {
    public static ArrayDirectory arrayDirectoryObj = new ArrayDirectory();
    public static Entry[] directoryEntries = new Entry[0];

    @Override
    public void insertEntry(Entry entry) {
        //This validates that the surname does not already exist in the Array
        String isInArray = lookupExtension(entry.getSurname());
        if (isInArray != null) {
            return;
        }
        //This creates an new array and adds the the value entry to it
        Entry[] tempArray = new Entry[directoryEntries.length + 1];
        System.arraycopy(directoryEntries, 0, tempArray, 0, directoryEntries.length);
        tempArray[directoryEntries.length] = entry;
        //This reassigns the new array back to the original
        directoryEntries = tempArray;
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        //This creates a new array and adds every value except the entry to be deleted
        Entry[] tempArray = new Entry[directoryEntries.length-1];
        int counter = 0;
        for (int i = 0; i < directoryEntries.length; i++) {
            if (!(directoryEntries[i].getSurname().equals(surname))) {
                tempArray[counter] = directoryEntries[i];
                counter += 1;
            }
        }
        //This reassigns the new array back to the original
        directoryEntries = tempArray;
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        //This creates a new Array and adds every value except the entry to be deleted
        Entry[] tempArray = new Entry[directoryEntries.length-1];
        int counter = 0;
        for (int i = 0; i < directoryEntries.length; i++) {
            if (!(directoryEntries[i].getTelephoneExtension().equals(number))) {
                tempArray[counter] = directoryEntries[i];
                counter += 1;
            }
        }
        //This reassigns the new Array back to the original
        directoryEntries = tempArray;
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        //This loops through the entries in the Array uses a setter to change the telephone extension when the entry
        //with the correct surname is found
        for (Entry directoryEntry : directoryEntries) {
            if (directoryEntry.getSurname().equals(surname)) {
                directoryEntry.setTelephoneExtension(newNumber);
            }
        }
    }

    @Override
    public String lookupExtension(String surname) {
        //This loops through the entries in the Array and returns telephone extension from the one with the
        //matching surname
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
        //This converts the Array to an ArrayList and returns the ArrayList
        ArrayList<Entry> arrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        return arrayList;
    }

}
