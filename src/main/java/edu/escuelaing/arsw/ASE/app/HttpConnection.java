package edu.escuelaing.arsw.ASE.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class HttpConnection {

    private static final String AGENTE = "Mozilla/5.0";
    private static String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&s=";
    private static final String API_KEY = "&apikey=Q1QZFVJQ21K7C6XM";


    public static String RsponseApi(String title) throws IOException {
        String respuestaApi = "";


        if (!Objects.equals(title, "")) {
            GET_URL += title;
            GET_URL += API_KEY;


            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();


            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", AGENTE);


            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);


            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                respuestaApi = response.toString();
            } else {
                respuestaApi = "GET request not worked";
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
        }

        GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&s=";

        return respuestaApi;
    }
}
