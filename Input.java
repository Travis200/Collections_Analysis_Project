import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {
    public Object[] readFile() throws IOException {
        ArrayList<Entry> fileDataArrayList = new ArrayList<Entry>();
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader("test_data_small.csv"));
        System.out.println(1);
        while ((row = csvReader.readLine()) != null) {
            System.out.println(2);
            String[] data = row.split(",");
            Entry fileLine = new Entry(data[0], data[1], data[2]);
            fileDataArrayList.add(fileLine);
            System.out.println(3);
        }
        Entry[] fileData = (Entry[]) fileDataArrayList.toArray();
        System.out.println(3);
        csvReader.close();
        System.out.println(4);
        return fileData;
        }

        public static void main (String[]args) throws IOException {
            Input obj = new Input();
            System.out.println(obj.readFile());
        }
    }

