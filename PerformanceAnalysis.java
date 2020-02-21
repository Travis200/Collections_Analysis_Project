import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PerformanceAnalysis {
    public static PerformanceAnalysis performanceAnalysisObj = new PerformanceAnalysis();
    public static StopWatch stopWatchObj = new StopWatch();
    public static Entry testEntry = new Entry("Higgins", "T.S.H", "01205");

    //These methods test the time taken to implement one cycle of the insertEntry method in each directory

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

    //These methods test the time taken to implement one cycle of the lookUpExtension method in each directory

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

    public long hashMapTestLookUp() throws IOException {
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

    //These methods test the time taken to implement one cycle of the deleteEntryUsingName method in each directory

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

    //These methods test the time taken to implement one cycle of the deleteEntryUsingExtension method in each directory

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


    //These methods are used to run the tests 1000 times and save the results to an array

    public long[] arrayInsertExecutions() {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayTestInsert();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] arrayListInsertExecutions() {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayListTestInsert();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] hashMapInsertExecutions() {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = hashMapTestInsert();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] arrayLookUpExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayTestLookUp();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] arrayListLookUpExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayListTestLookUp();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] hashMapLookUpExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = hashMapTestLookUp();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] arrayDeleteSurnameExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayTestDeleteSurname();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] arrayListDeleteSurnameExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayListTestDeleteSurname();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] hashMapDeleteSurnameExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = hashMapTestDeleteSurname();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] arrayDeleteExtensionExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayTestDeleteExtension();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }
    public long[] arrayListDeleteExtensionExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = arrayListTestDeleteExtension();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    public long[] hashMapDeleteExtensionExecutions() throws IOException {
        ArrayList<Long> arrayListOfTimes = new ArrayList<Long>();
        for (int i = 0; i < 1000; i++) {
            long time = hashMapTestDeleteExtension();
            arrayListOfTimes.add(time);
        }
        long[] result = bestWorstMeanCalc(arrayListOfTimes);
        return result;
    }

    //This method calculates the best worst and mean average and returns the values in an array
    public long[] bestWorstMeanCalc(ArrayList<Long> arrayListOfTimes){
        Long[] arrayOfTimes = arrayListOfTimes.toArray(new Long[0]);
        Arrays.sort(arrayOfTimes);
        Long bestExecution = arrayOfTimes[0];
        Long worstExecution = arrayOfTimes[arrayOfTimes.length - 1];
        long totalOfAllExecutions = 0;
        long counter = 0;
        for (Long executionTime : arrayOfTimes) {
            counter += 1;
            totalOfAllExecutions += executionTime;
        }
        long meanExecution = totalOfAllExecutions / counter;
        long[] arrayOfResults = {bestExecution, worstExecution, meanExecution};
        return arrayOfResults;
    }
    //This method adds all of the results from the performance analysis to a 2D Array
    public long[][] arrayOfResults() throws IOException {
        long[][] resultsArray = new long[12][3];
        resultsArray[0] = performanceAnalysisObj.arrayInsertExecutions();
        resultsArray[1] = performanceAnalysisObj.arrayListInsertExecutions();
        resultsArray[2] = performanceAnalysisObj.hashMapInsertExecutions();
        resultsArray[3] = performanceAnalysisObj.arrayLookUpExecutions();
        resultsArray[4] = performanceAnalysisObj.arrayListLookUpExecutions();
        resultsArray[5] = performanceAnalysisObj.hashMapLookUpExecutions();
        resultsArray[6] = performanceAnalysisObj.arrayDeleteSurnameExecutions();
        resultsArray[7] = performanceAnalysisObj.arrayListDeleteSurnameExecutions();
        resultsArray[8] = performanceAnalysisObj.hashMapDeleteSurnameExecutions();
        resultsArray[9] = performanceAnalysisObj.arrayDeleteExtensionExecutions();
        resultsArray[10] = performanceAnalysisObj.arrayListDeleteExtensionExecutions();
        resultsArray[11] = performanceAnalysisObj.hashMapDeleteExtensionExecutions();
        return resultsArray;
        }
}

