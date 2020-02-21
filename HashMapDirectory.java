import java.util.*;

public class HashMapDirectory implements Directory {
    //In this directory I have made two HashMaps, one that uses the surname as the key and the other the tel extension
    public static HashMapDirectory hashMapDirectoryObj = new HashMapDirectory();
    public static HashMap<String, Entry> surnameHashMap = new HashMap<String, Entry>();
    public static HashMap<String, Entry> telExtensionHashMap = new HashMap<String, Entry>();
    @Override
    //This method inserts an entry into both the HashMaps
    public void insertEntry(Entry entry) {
        //This validates that the surname does not already exist in the HashMap
        String isInHashMap = lookupExtension(entry.getSurname());
        if (isInHashMap != null) {
            return;
        }
        //This inserts the entries into two HashMaps
        String surname = entry.getSurname();
        String telExtension = entry.getTelephoneExtension();
        surnameHashMap.put(surname, entry);
        telExtensionHashMap.put(telExtension, entry);
    }
    @Override
    //This method finds the tel extension from the surname and uses both as keys to delete the entry from both HashMaps
    public void deleteEntryUsingName(String surname) {
        String telExt = surnameHashMap.get(surname).getTelephoneExtension();
        surnameHashMap.remove(surname);
        telExtensionHashMap.remove(telExt);

    }

    @Override
    //This method finds the surname from the tel extension and uses both as keys to delete the entry from both HashMaps
    public void deleteEntryUsingExtension(String number) {
        String surname = telExtensionHashMap.get(number).getSurname();
        telExtensionHashMap.remove(number);
        surnameHashMap.remove(surname);
    }

    @Override
    //This method takes the a surname and extension as a parameter and then updates the entry with surname with the
    //new telephone extension in both HashMaps
    public void updateExtensionUsingName(String surname, String newNumber) {
        Entry entryToChange = surnameHashMap.get(surname);
        String telExtKeyToChange = entryToChange.getTelephoneExtension();
        entryToChange.setTelephoneExtension(newNumber);
        telExtensionHashMap.remove(telExtKeyToChange);
        telExtensionHashMap.put(newNumber,entryToChange);
        surnameHashMap.put(surname,entryToChange);

    }


    @Override
    //This method uses the surname HashMap keys to find if the surname exists and the returns the tel extension from
    //the entry associated with that key
    public String lookupExtension(String surname) {
        String returnValue = null;
        if(surnameHashMap.containsKey(surname)) {
            returnValue = surnameHashMap.get(surname).getTelephoneExtension();
        }
        return returnValue;

    }

    @Override
    //This creates an ArrayList from the tel extension HashMap values
    public List<Entry> toArrayList() {
        ArrayList<Entry> returnArrayList = new ArrayList<Entry>(telExtensionHashMap.values());
        return returnArrayList;
    }


}
