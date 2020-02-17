import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    public Object[] readFile() throws IOException {
        ArrayList<Entry> fileDataArrayList = new ArrayList<Entry>();
        //Entry[] fileData = null;
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader("test_data_small.csv"));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            System.out.println("this");
            System.out.println(data[0]);
            //System.out.println(data);
            Entry fileLine = new Entry(data[0], data[1], data[2]);
            //System.out.println(Arrays.toString(data));
            fileDataArrayList.add(fileLine);
            //System.out.println(fileLine);
        }
        //System.out.println(fileDataArrayList);
        Entry test;
        Entry[] fileData = (Entry[]) fileDataArrayList.toArray();
        //System.out.println(fileData);
        csvReader.close();
        return fileData;
        }

        public static void main (String[]args) throws IOException {
            Input obj = new Input();
            obj.readFile();
    /*public static void main(String[] args) throws IOException{
        ReadFile test = new ReadFile();
        System.out.println((Arrays.toString(test.readFile())));
    }*/
        }
    }

