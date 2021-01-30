package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TODO refactor to only public functions without constuctor


public class CSVReader {

    private static List<List<String>> records; //TODO change to List<String>


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
            String[] Ausgabe = new String[5];

            int i = 0, j = 0;
            while (null != (zeile = FileReader.readLine())) {         //lesen jeder Zeile
                String[] split = zeile.split("\n");                //hier wird die Zeile zerlegt als Trennzeichen ;
                // System.out.print(split[0]);                     //erste index 0
                // System.out.println(" --> ");

                records.add(getRecordFromLine(split[0]));

                i++;
                System.out.println(i);


                Ausgabe = getValuesFromString(records);

                //if (records.get(0).get(0).equals("")) {
                    records.remove(0);
                //}
                /*if (i == 6) {
                    break;
                }*/
            }
           // System.out.print("record1= " + records.get(0).get(1));

            for (int k = 0; k < 6; k++) {
                System.out.println("Ausgabe= " + Ausgabe[k]);
            }
            //System.out.print("Ausgabe= " + Ausgabe);
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

    private static String[] getValuesFromString (List<List<String>> records) {
        String[] Ausgabe = new String[6];

        Ausgabe[0] = records.get(0).get(0); // EAN
        Ausgabe[1] = records.get(0).get(7); // Name
        Ausgabe[2] = records.get(0).get(66); // ImageURL
        Ausgabe[3] = records.get(0).get(11); // Packaging
        Ausgabe[4] = records.get(0).get(13); // Brand
        Ausgabe[5] = "7";

        for (int k = 0; k < 6; k++) {
            System.out.println("Ausgabe= " + Ausgabe[k]);
        }

        return Ausgabe;
    }

}
