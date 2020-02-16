import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
import java.util.Arrays;

public class ReadFile {
    //public static ReadFile test = new ReadFile();

    public Object[] readFile() throws IOException {
        ArrayList<Entry> fileDataArrayList = new ArrayList<Entry>();
        //Entry[] fileData = null;
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader("test_data_small.csv"));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            Entry fileLine = new Entry(data[0], data[1], data[2]);
            fileDataArrayList.add(fileLine);
            //System.out.println(fileLine);
        }
        System.out.println(fileDataArrayList);
        //Should change this to Entry[]?
        Object[] fileData = fileDataArrayList.toArray();
        csvReader.close();
        return fileData;
    }

    /*public static void main(String[] args) throws IOException{
        ReadFile test = new ReadFile();
        System.out.println((Arrays.toString(test.readFile())));
    }*/
}
