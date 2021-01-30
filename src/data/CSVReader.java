package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    private static List<List<String>> records;


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

            String[] Ausgabe = new String[5];
            int i=0, value = 0;
            //TODO erste Zeile muss übersprungen werden, da dies die Spaltennamen sind
            while (null != (zeile = FileReader.readLine())) {         //lesen jeder Zeile
                String[] split = zeile.split("\n");                //hier wird die Zeile zerlegt als Trennzeichen

                records.add(getRecordFromLine(split[0]));
                Ausgabe = getValuesFromString(records);

                //Senden der Daten an Datenbank
                URLCreator.sendPostRequest(Main.address, Ausgabe);
                System.out.println(i);

                if(i>=value+1000) {
                    Thread.sleep(5000);
                    value=value+1000;
                }

                records.remove(0);
                i++;
                if(i>=100000) {
                    break;
                }
            }

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

        //Ausgabe der Daten
        /*
        for (int k = 0; k < 6; k++) {
            System.out.println("Ausgabe= " + Ausgabe[k]);
        }
        */

        return Ausgabe;
    }

}
