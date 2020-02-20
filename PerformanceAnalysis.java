import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class PerformanceAnalysis {
    public static PerformanceAnalysis performanceAnalysisObj = new PerformanceAnalysis();
    public static StopWatch stopWatchObj = new StopWatch();
    public static Entry testEntry = new Entry("Higgins", "T.S.H", "01205");

    public long arrayTestInsert() {
        stopWatchObj.reset();
        stopWatchObj.start();
        ArrayDirectory.arrayDirectoryObj.insertEntry(testEntry);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long arrayListTestInsert() {
        stopWatchObj.reset();
        stopWatchObj.start();
        ArrayListDirectory.arrayListDirectoryObj.insertEntry(testEntry);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long hashMapTestInsert() {
        stopWatchObj.reset();
        stopWatchObj.start();
        HashMapDirectory.hashMapDirectoryObj.insertEntry(testEntry);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long arrayTestLookUp() throws IOException {
        stopWatchObj.reset();
        Input.inputObj.readFile("test_data.csv", "1");
        ArrayList<Entry> arr = (ArrayList<Entry>) ArrayDirectory.arrayDirectoryObj.toArrayList();
        int entryIndexInMiddle = (arr.size()) / 2;
        String surnameToLookUp = arr.get(entryIndexInMiddle).getSurname();
        stopWatchObj.start();
        ArrayDirectory.arrayDirectoryObj.lookupExtension(surnameToLookUp);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long arrayListTestLookUp() throws IOException {
        {
            stopWatchObj.reset();
            Input.inputObj.readFile("test_data.csv", "2");
            ArrayList<Entry> arr = (ArrayList<Entry>) ArrayListDirectory.arrayListDirectoryObj.toArrayList();
            int entryIndexInMiddle = (arr.size()) / 2;
            String surnameToLookUp = arr.get(entryIndexInMiddle).getSurname();
            stopWatchObj.start();
            ArrayListDirectory.arrayListDirectoryObj.lookupExtension(surnameToLookUp);
            stopWatchObj.stop();
            return stopWatchObj.getElapsedTime();
        }
    }

    public long hashMapTestLookup() throws IOException {
        stopWatchObj.reset();
        Input.inputObj.readFile("test_data.csv", "3");
        ArrayList<Entry> arr = (ArrayList<Entry>) HashMapDirectory.hashMapDirectoryObj.toArrayList();
        int entryIndexInMiddle = (arr.size()) / 2;
        String surnameToLookUp = arr.get(entryIndexInMiddle).getSurname();
        stopWatchObj.start();
        ArrayListDirectory.arrayListDirectoryObj.lookupExtension(surnameToLookUp);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long arrayTestDeleteSurname() throws IOException {
        stopWatchObj.reset();
        Input.inputObj.readFile("test_data.csv", "1");
        ArrayList<Entry> arr = (ArrayList<Entry>) ArrayDirectory.arrayDirectoryObj.toArrayList();
        int entryIndexInMiddle = (arr.size()) / 2;
        String surnameToDelete = arr.get(entryIndexInMiddle).getSurname();
        stopWatchObj.start();
        ArrayDirectory.arrayDirectoryObj.deleteEntryUsingName(surnameToDelete);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long arrayListTestDeleteSurname() throws IOException {
        stopWatchObj.reset();
        Input.inputObj.readFile("test_data.csv", "2");
        ArrayList<Entry> arr = (ArrayList<Entry>) ArrayListDirectory.arrayListDirectoryObj.toArrayList();
        int entryIndexInMiddle = (arr.size()) / 2;
        String surnameToDelete = arr.get(entryIndexInMiddle).getSurname();
        stopWatchObj.start();
        ArrayListDirectory.arrayListDirectoryObj.deleteEntryUsingName(surnameToDelete);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long hashMapTestDeleteSurname() throws IOException {
        stopWatchObj.reset();
        Input.inputObj.readFile("test_data.csv", "3");
        ArrayList<Entry> arr = (ArrayList<Entry>) HashMapDirectory.hashMapDirectoryObj.toArrayList();
        int entryIndexInMiddle = (arr.size()) / 2;
        String surnameToDelete = arr.get(entryIndexInMiddle).getSurname();
        stopWatchObj.start();
        HashMapDirectory.hashMapDirectoryObj.deleteEntryUsingName(surnameToDelete);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long arrayTestDeleteExtension() throws IOException {
        stopWatchObj.reset();
        Input.inputObj.readFile("test_data.csv", "1");
        ArrayList<Entry> arr = (ArrayList<Entry>) ArrayDirectory.arrayDirectoryObj.toArrayList();
        int entryIndexInMiddle = (arr.size()) / 2;
        String telExtToDelete = arr.get(entryIndexInMiddle).getTelephoneExtension();
        stopWatchObj.start();
        ArrayDirectory.arrayDirectoryObj.deleteEntryUsingExtension(telExtToDelete);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long arrayListTestDeleteExtension() throws IOException {
        stopWatchObj.reset();
        Input.inputObj.readFile("test_data.csv", "2");
        ArrayList<Entry> arr = (ArrayList<Entry>) ArrayListDirectory.arrayListDirectoryObj.toArrayList();
        int entryIndexInMiddle = (arr.size()) / 2;
        String telExtToDelete = arr.get(entryIndexInMiddle).getTelephoneExtension();
        stopWatchObj.start();
        ArrayListDirectory.arrayListDirectoryObj.deleteEntryUsingExtension(telExtToDelete);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public long hashMapTestDeleteExtension() throws IOException {
        stopWatchObj.reset();
        Input.inputObj.readFile("test_data.csv", "3");
        ArrayList<Entry> arr = (ArrayList<Entry>) HashMapDirectory.hashMapDirectoryObj.toArrayList();
        int entryIndexInMiddle = (arr.size()) / 2;
        String telExtToDelete = arr.get(entryIndexInMiddle).getTelephoneExtension();
        stopWatchObj.start();
        HashMapDirectory.hashMapDirectoryObj.deleteEntryUsingExtension(telExtToDelete);
        stopWatchObj.stop();
        return stopWatchObj.getElapsedTime();
    }

    public void analysis() {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayTestInsert();
            //System.out.println(time);
            //Integer x = (int) (long) time;
            arrayListOfTimes.add(time);

        }
        System.out.println(arrayListOfTimes);
        Long[] arrayOfTimes = arrayListOfTimes.toArray(new Long[0]);
        //Arrays.stream(arrayOfTimes).filter(Objects::nonNull).mapToLong(Long::longValue).toArray();

        //long[] arrayOfTimesPrimitive = ArrayUtils.toPrimitive(arrayListOfTimes);
        Arrays.sort(arrayOfTimes);
        Long bestExecution = arrayOfTimes[0];
        Long worstExecution = arrayOfTimes[arrayOfTimes.length-1];
        System.out.println(bestExecution);
        System.out.println(worstExecution);
        long averageExecution = 0;
        long totalOfAllExecutions = 0;
        long counter = 0;
        for (Long executionTime : arrayOfTimes) {
            counter += 1;
            totalOfAllExecutions += executionTime;
        }
        System.out.println(totalOfAllExecutions);
        long meanExecution = totalOfAllExecutions/counter;
        System.out.println(meanExecution);

    }
}

