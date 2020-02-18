import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapDirectory implements Directory {
    public static HashMap<String, Entry> surnameHashMap = new HashMap<String, Entry>();
    public static HashMap<String, Entry> telExtensionHashMap = new HashMap<String, Entry>();
    public static AtomicInteger atomicInteger = new AtomicInteger();
    public static Integer counter = 0;
    @Override
    public void insertEntry(Entry entry) {
        counter = atomicInteger.incrementAndGet();
        String surname = entry.getSurname();
        String telExtension = entry.getTelephoneExtension();
        surnameHashMap.put(surname, entry);
        telExtensionHashMap.put(telExtension, entry);
    }
    @Override
    public void deleteEntryUsingName(String surname) {
        Entry entryVal = surnameHashMap.get(surname);
        for (String key : telExtensionHashMap.keySet()) {
            Entry value = telExtensionHashMap.get(key);
            if (value == entryVal) {
                telExtensionHashMap.remove(key);
                break;
            }
        }
        surnameHashMap.remove(surname);
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        Entry entryVal = telExtensionHashMap.get(number);
        for (String key : surnameHashMap.keySet()) {
            Entry value = surnameHashMap.get(key);
            if (value == entryVal) {
                surnameHashMap.remove(key);
                break;
            }
        }
        telExtensionHashMap.remove(number);
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        Entry entryToChange = null;
        String telExtKeyToChange = null;
        Entry entryVal = surnameHashMap.get(surname);
        for (String key : telExtensionHashMap.keySet()) {
            Entry value = telExtensionHashMap.get(key);
            if (value == entryVal) {
                //System.out.println(key);
                telExtKeyToChange = key;
                entryToChange = value;
                System.out.println(entryToChange.getTelephoneExtension());
                break;
            }
        }
        entryToChange.setTelephoneExtension(newNumber);
        System.out.println(entryToChange.getTelephoneExtension());
        telExtensionHashMap.remove(telExtKeyToChange);
        telExtensionHashMap.put(newNumber,entryToChange);
        surnameHashMap.put(surname,entryToChange);



    }


    @Override
    public String lookupExtension(String surname) {
        String returnValue = null;
        Entry entryVal = surnameHashMap.get(surname);
        for (String key : telExtensionHashMap.keySet()) {
            Entry value = telExtensionHashMap.get(key);
            if (value == entryVal) {
                returnValue = key;
                break;
            }
        }
        return returnValue;
    }

    @Override
    public List<Entry> toArrayList() {
        ArrayList<Entry> returnArrayList = new ArrayList<Entry>(telExtensionHashMap.values());
        return returnArrayList;
    }

    public static void main(String[] args) {
        //System.out.println("hello world");
        HashMapDirectory obj3 = new HashMapDirectory();
        Entry entry1 = new Entry("Higgins", "T.S.H", "11111");
        Entry entry2 = new Entry("Waterhouse","L.W.W","22222");
        Entry entry3 = new Entry("Mclaughlin", "M.M.M", "33333");
        obj3.insertEntry(entry1);
        obj3.insertEntry(entry2);
        obj3.insertEntry(entry3);
        obj3.updateExtensionUsingName("Higgins", "44444");
        System.out.println(obj3.toArrayList());
        //obj3.deleteEntryUsingName("Higgins");
        //obj3.deleteEntryUsingExtension("22222");
        //System.out.println(obj3.lookupExtension("Waterhouse"));
        //System.out.println(surnameHashMap);
        //System.out.println(telExtensionHashMap);
        //Entry testing1 = surnameHashMap.get("Higgins");
        //System.out.println(testing1.getTelephoneExtension());
    }
}
