import java.util.ArrayList;
import java.util.List;

public class ArrayListDirectory implements Directory {
        public static ArrayListDirectory arrayListDirectoryObj = new ArrayListDirectory();
        public static ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>();

        @Override
        public void insertEntry(Entry entry) {
            //This validates that the surname does not already exist in the ArrayList
            String isInArrayList = lookupExtension(entry.getSurname());
            if (isInArrayList != null) {
                return;
            }
            //This adds the entry to the ArrayList
            directoryEntriesArrayList.add(entry);
        }
        @Override
        public void deleteEntryUsingName(String surname) {
            //This loops through the ArrayList and removes the entry with the specified surname
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                    directoryEntriesArrayList.remove(i);
                }
            }
        }

        @Override
        public void deleteEntryUsingExtension(String number) {
            //This loops through the ArrayList and removes the entry with the specified telephone extension
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getTelephoneExtension().equals(number)) {
                    directoryEntriesArrayList.remove(i);
                }
            }
        }

        @Override
        public void updateExtensionUsingName(String surname, String newNumber) {
            //This loops through the ArrayList and updates the telephone extension of the entry with the
            //specified surname
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                    directoryEntriesArrayList.get(i).setTelephoneExtension(newNumber);
                }
            }
        }

        @Override
        public String lookupExtension(String surname) {
            //This loops through the entries in the ArrayList until and returns telephone extension from the one with the
            //matching surname
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
            //This method returns the ArrayList
            return directoryEntriesArrayList;
        }

}
