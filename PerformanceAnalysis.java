public class PerformanceAnalysis {
public static StopWatch stopWatchObj = new StopWatch();
public static Entry testEntry = new Entry("Higgins", "T.S.H", "01205");

    public void arrayTestInsert() {
        stopWatchObj.reset();
        stopWatchObj.start();
        ArrayDirectory.arrayDirectoryObj.insertEntry(testEntry);
        stopWatchObj.stop();
    }
    public void arrayListTestInsert(){

    }
    public void hashMapTestInsert(){

    }

    public void arrayTestLookUp() {

    }
    public void arrayListTestLookUp(){

    }
    public void hashMapTestInsertLookup(){

    }

    public void arrayTestDeleteSurname() {

    }
    public void arrayListTestDeleteSurname(){

    }
    public void hashMapTestDeleteSurname(){

    }

    public void arrayTestDeleteExtension() {

    }
    public void arrayListTestDeleteExtension(){

    }
    public void hashMapTestDeleteExtension(){

    }
}

