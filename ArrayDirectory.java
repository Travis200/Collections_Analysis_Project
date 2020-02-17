import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory {

    public static Entry[] directoryEntries = new Entry[0];

    @Override
    public void insertEntry(Entry entry) {
        //Does not work
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        directoryEntriesArrayList.add(entry);
        this.directoryEntries = new Entry[directoryEntriesArrayList.size()];
        this.directoryEntries = directoryEntriesArrayList.toArray(this.directoryEntries);
        //System.out.println(directoryEntries);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            //System.out.println(directoryEntriesArrayList.get(i).getSurname());
            if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                //System.out.println();
                directoryEntriesArrayList.remove(i);
            }
            while(directoryEntriesArrayList.remove(null));
            this.directoryEntries = directoryEntriesArrayList.toArray(this.directoryEntries);

        }
        //System.out.println(Arrays.toString(directoryEntries));
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
                //Insert code here
            }
            this.directoryEntries = directoryEntriesArrayList.toArray(this.directoryEntries);
        }
        //System.out.println(Arrays.toString(directoryEntries));
    }

    @Override
    public String lookupExtension(String surname) {
        ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
        String result = "";
        System.out.println();
        for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
            //System.out.println(i);
            if (directoryEntriesArrayList.get(i).getTelephoneExtension().equals(surname)) {
                System.out.println("Hello");
                result = directoryEntriesArrayList.get(i).getTelephoneExtension();
            }
        }
        //System.out.println(Arrays.toString(directoryEntries));
        return result;
    }

    @Override
    public List<Entry> toArrayList() {
        List<Entry> thing = Arrays.asList(directoryEntries);
        //System.out.println(Arrays.toString(directoryEntries));
        return thing;
    }

    public static void main(String[] args) {
        ArrayDirectory obj1 = new ArrayDirectory();
        Entry entry1 = new Entry("Higgins", "T.S.H", "11111");
        Entry entry2 = new Entry("Waterhouse","L.W","22222");
        Entry entry3 = new Entry("Mclaughlin", "M.M.M", "33333");
        obj1.insertEntry(entry1);
        obj1.insertEntry(entry2);
        obj1.insertEntry(entry3);
        obj1.deleteEntryUsingName("Higgins");
        //obj1.lookupExtension("Higgins");
        //obj1.updateExtensionUsingName("Higgins", "01205");
        //System.out.println(directoryEntries.length);
        for(int i=0;i<directoryEntries.length;i++){
            //System.out.println(directoryEntries.length);
            //System.out.println(i);
            System.out.println(directoryEntries[i].getSurname());
        }

    }
}
