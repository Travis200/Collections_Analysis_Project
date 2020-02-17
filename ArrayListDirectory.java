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
            /*int lengthOfDE2 = ((directoryEntries.length)-1);
            Entry[] directoryEntries2 = new Entry[lengthOfDE2];
            ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                    directoryEntriesArrayList.remove(i);
                }
            }
            directoryEntries2 = directoryEntriesArrayList.toArray(directoryEntries2);
            directoryEntries = directoryEntries2;*/
        }

        @Override
        public void deleteEntryUsingExtension(String number) {/*
            int lengthOfDE2 = ((directoryEntries.length)-1);
            Entry[] directoryEntries2 = new Entry[lengthOfDE2];
            ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getTelephoneExtension().equals(number)) {
                    directoryEntriesArrayList.remove(i);
                }
            }
            directoryEntries2 = directoryEntriesArrayList.toArray(directoryEntries2);
            directoryEntries = directoryEntries2;*/
        }

        @Override
        public void updateExtensionUsingName(String surname, String newNumber) {/*
            ArrayList<Entry> directoryEntriesArrayList = new ArrayList<Entry>(Arrays.asList(directoryEntries));
            for (int i = 0; i < directoryEntriesArrayList.size(); i++) {
                if (directoryEntriesArrayList.get(i).getSurname().equals(surname)) {
                    directoryEntriesArrayList.get(i).setTelephoneExtension(newNumber);

                }
                directoryEntries = directoryEntriesArrayList.toArray(directoryEntries);
            }*/
        }

        @Override
        public String lookupExtension(String surname) {/*
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
            */
            return null;
        }

        @Override
        public List<Entry> toArrayList() {/*
            List<Entry> arrayList = Arrays.asList(directoryEntries);
            return arrayList;*/
            return null;
        }

        public static void main(String[] args) {
            ArrayDirectory obj2 = new ArrayDirectory();
            Entry entry1 = new Entry("Higgins", "T.S.H", "11111");
            Entry entry2 = new Entry("Waterhouse","L.W.W","22222");
            Entry entry3 = new Entry("Mclaughlin", "M.M.M", "33333");
            obj2.insertEntry(entry1);
            obj2.insertEntry(entry2);
            obj2.insertEntry(entry3);
            Entry[] directoryEntries = new Entry[0];
            //System.out.println(directoryEntries);
            System.out.println(Arrays.toString(directoryEntries));
            //directoryEntries = directoryEntriesArrayList.toArray(directoryEntries);
            //for(int i=0;i<directoryEntries.length;i++){
                //System.out.println(directoryEntries[i].getSurname());
            //}


        }

}
