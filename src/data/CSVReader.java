package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TODO refactor to only public functions without constuctor

public class CSVReader {

    private List<List<String>> records; //TODO change to List<String>

    public CSVReader() {
        records = new ArrayList<>();
        try {
            java.io.BufferedReader FileReader =                      //ein Reader um die Datei Zeilenweise auszulesen
                    new java.io.BufferedReader(
                            new java.io.FileReader(
                                    new java.io.File(Main.path)
                            )
                    );

            String zeile = "";

            //TODO change output to single line
            int i = 0;
            while (null != (zeile = FileReader.readLine())) {         //lesen jeder Zeile
                String[] split = zeile.split("\n");                //hier wird die Zeile zerlegt als Trennzeichen ;
                // System.out.print(split[0]);                     //erste index 0
                // System.out.println(" --> ");

                records.add(getRecordFromLine(split[0]));

                i++;
                System.out.println(i);

            }
            System.out.print("record1= " + records.get(2).get(2));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter("\t");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
