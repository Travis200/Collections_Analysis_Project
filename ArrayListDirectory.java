import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDirectory implements Directory {
        public static ArrayListDirectory arrayListDirectoryObj = new ArrayListDirectory();
        public static ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>();

        @Override
        public void insertEntry(Entry entry) {
            String isInArrayList = lookupExtension(entry.getSurname());
            if (isInArrayList != null) {
                return;
            }
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

}
