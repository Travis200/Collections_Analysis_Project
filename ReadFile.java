import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    public Entry[] readFile() throws IOException {
        ArrayList<Entry> fileDataArrayList = new ArrayList<Entry>();
        Entry[] fileData = null;
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader("test_data.csv"));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            Entry fileLine = new Entry(data[0], data[1], data[2]);
            fileDataArrayList.add(fileLine);
        }
        fileData = fileDataArrayList.toArray(fileData);
        csvReader.close();
        return fileData;
    }
}
