import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapDirectory implements Directory {
    public static HashMapDirectory hashMapDirectoryObj = new HashMapDirectory();
    public static HashMap<String, Entry> surnameHashMap = new HashMap<String, Entry>();
    public static HashMap<String, Entry> telExtensionHashMap = new HashMap<String, Entry>();
    @Override
    public void insertEntry(Entry entry) {
        String isInHashMap = lookupExtension(entry.getSurname());
        if (isInHashMap != null) {
            return;
        }
        String surname = entry.getSurname();
        String telExtension = entry.getTelephoneExtension();
        surnameHashMap.put(surname, entry);
        telExtensionHashMap.put(telExtension, entry);
    }
    @Override
    public void deleteEntryUsingName(String surname) {
        String telExt = surnameHashMap.get(surname).getTelephoneExtension();
        surnameHashMap.remove(surname);
        telExtensionHashMap.remove(telExt);

    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        String surname = telExtensionHashMap.get(number).getSurname();
        telExtensionHashMap.remove(number);
        surnameHashMap.remove(surname);
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        Entry entryToChange = surnameHashMap.get(surname);
        String telExtKeyToChange = entryToChange.getTelephoneExtension();
        entryToChange.setTelephoneExtension(newNumber);
        telExtensionHashMap.remove(telExtKeyToChange);
        telExtensionHashMap.put(newNumber,entryToChange);
        surnameHashMap.put(surname,entryToChange);



    }


    @Override
    public String lookupExtension(String surname) {
        String returnValue = null;
        if(surnameHashMap.containsKey(surname)) {
            returnValue = surnameHashMap.get(surname).getTelephoneExtension();
        }
        return returnValue;

    }

    @Override
    public List<Entry> toArrayList() {
        ArrayList<Entry> returnArrayList = new ArrayList<Entry>(telExtensionHashMap.values());
        return returnArrayList;
    }


}
