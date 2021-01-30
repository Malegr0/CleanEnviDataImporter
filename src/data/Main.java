package data;

import java.io.IOException;

public class Main {

    public static final String path = "D:\\Dokumente\\products.csv";
    public static final String address = "http://192.168.1.5:8080/products";

    public static void main(String[] args) throws IOException {
        new CSVReader();
    }

}
