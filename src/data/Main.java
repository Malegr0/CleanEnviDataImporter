package data;

import java.io.IOException;

public class Main {

    public static final String path = "C:\\Users\\chris\\Documents\\SWE2\\TestCSV\\en.openfoodfacts.org.products.csv";
    public static final String address = "http://malegro.ddns.net:8080/products";

    public static void main(String[] args) throws IOException {
        //new CSVReader();

        String[] test = {"bla", "ich bin der Test", "ich bin eine imageurl", "ich bin eine verpackung", "ich bin eine testmarke", "7"};

        URLCreator.sendPostRequest(address, test);
    }

}
