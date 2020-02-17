import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory {

    public static Entry[] directoryEntries = new Entry[0];

    @Override
    public void insertEntry(Entry entry) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        directoryEntriesArrayList.add(entry);
        directoryEntries = new Entry[directoryEntriesArrayList.size()];
        directoryEntries = directoryEntriesArrayList.toArray(directoryEntries);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        int lengthOfDE2 = ((directoryEntries.length)-1);
        Entry[] directoryEntries2 = new Entry[lengthOfDE2];
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                directoryEntriesArrayList.remove(i);
            }
        }
        directoryEntries2 = directoryEntriesArrayList.toArray(directoryEntries2);
        directoryEntries = directoryEntries2;
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        int lengthOfDE2 = ((directoryEntries.length)-1);
        Entry[] directoryEntries2 = new Entry[lengthOfDE2];
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            if (directoryEntriesArrayList.get(i).getTelephoneExtension().equals(number)) {
                directoryEntriesArrayList.remove(i);
            }
        }
        directoryEntries2 = directoryEntriesArrayList.toArray(directoryEntries2);
        directoryEntries = directoryEntries2;
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                directoryEntriesArrayList.get(i).setTelephoneExtension(newNumber);

            }
            directoryEntries = directoryEntriesArrayList.toArray(directoryEntries);
        }
    }

    @Override
    public String lookupExtension(String surname) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        String result = "";
        System.out.println();
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                System.out.println("Hello");
                result = directoryEntriesArrayList.get(i).getTelephoneExtension();
            }
        }
        return result;
    }

    @Override
    public List<Entry> toArrayList() {
        List<Entry> arrayList = Arrays.asList(directoryEntries);
        return arrayList;
    }

    public static void main(String[] args) {
        ArrayDirectory obj1 = new ArrayDirectory();
        Entry entry1 = new Entry("Higgins", "T.S.H", "11111");
        Entry entry2 = new Entry("Waterhouse","L.W.W","22222");
        Entry entry3 = new Entry("Mclaughlin", "M.M.M", "33333");
        obj1.insertEntry(entry1);
        obj1.insertEntry(entry2);
        obj1.insertEntry(entry3);
        obj1.updateExtensionUsingName("Higgins", "44444");
        for(int i=0;i<directoryEntries.length;i++){
            System.out.println(directoryEntries[i].getTelephoneExtension());
        }

    }
}
