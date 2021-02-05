package data;

import java.io.*;

public class CSVWriter {

    private static File csv_file;

    public static void init_CSVWriter() {
        csv_file = new File("not_added_data.csv");
        try (FileWriter writer = new FileWriter(csv_file)) {
            StringBuilder sb = new StringBuilder();

            sb.append("EAN");
            sb.append(";");
            sb.append("Name");
            sb.append(";");
            sb.append("ImageURL");
            sb.append(";");
            sb.append("Packaging");
            sb.append(";");
            sb.append("Brand");
            sb.append("\n");

            writer.append(sb.toString());
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addLine(String[] values) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter(csv_file, true)) {
            StringBuilder sb = new StringBuilder();

            sb.append(values[0]);
            sb.append(";");
            sb.append(values[1]);
            sb.append(";");
            sb.append(values[2]);
            sb.append(";");
            sb.append(values[3]);
            sb.append(";");
            sb.append(values[4]);
            sb.append("\n");

            writer.append(sb.toString());
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
