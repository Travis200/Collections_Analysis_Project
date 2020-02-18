import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDirectory implements Directory {

        public static ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>();

        @Override
        public void insertEntry(Entry entry) {
            directoryEntriesArrayList.add(entry);
        }

        @Override
        public void deleteEntryUsingName(String surname) {
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                    directoryEntriesArrayList.remove(i);
                }
            }
        }

        @Override
        public void deleteEntryUsingExtension(String number) {
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getTelephoneExtension().equals(number)) {
                    directoryEntriesArrayList.remove(i);
                }
            }
        }

        @Override
        public void updateExtensionUsingName(String surname, String newNumber) {
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                    directoryEntriesArrayList.get(i).setTelephoneExtension(newNumber);
                }
            }
        }

        @Override
        public String lookupExtension(String surname) {
            String result = null;
            System.out.println();
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                    result = directoryEntriesArrayList.get(i).getTelephoneExtension();
                }
            }
            return result;

        }

        @Override
        public List<Entry> toArrayList() {
            return directoryEntriesArrayList;
        }

        public static void main(String[] args) {
            ArrayListDirectory obj2 = new ArrayListDirectory();
            Entry entry1 = new Entry("Higgins", "T.S.H", "11111");
            Entry entry2 = new Entry("Waterhouse","L.W.W","22222");
            Entry entry3 = new Entry("Mclaughlin", "M.M.M", "33333");
            obj2.insertEntry(entry1);
            obj2.insertEntry(entry2);
            obj2.insertEntry(entry3);
            //System.out.println(obj2.toArrayList());
            //Entry[] directoryEntries = new Entry[2];
            //System.out.println(directoryEntries);
            System.out.println(directoryEntriesArrayList);
            for(int i=0;i<directoryEntriesArrayList.size();i++){
                System.out.println(directoryEntriesArrayList.get(i).getTelephoneExtension());
            }


        }

}
