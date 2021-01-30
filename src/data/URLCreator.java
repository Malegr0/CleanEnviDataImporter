package data;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class URLCreator {

    public static void sendPostRequest(String address, String[] values) throws IOException {
        //Setting up the connection
        URL url = new URL(address);
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST");
        http.setDoOutput(true);

        //Setting up and convert the values which will be send
        Map<String,String> arguments = new HashMap<>();
        arguments.put("ean", values[0]);
        arguments.put("name", values[1]);
        arguments.put("imageurl", values[2]);
        arguments.put("packaging", values[3]);
        arguments.put("brand", values[4]);
        arguments.put("recnumber", values[5]);
        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet()) {
            sj.add(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + "=" + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        //Sending data
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        //Closing connection
        http.disconnect();
    }

}
