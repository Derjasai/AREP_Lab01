package edu.escuelaing.arep.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "http://www.omdbapi.com/?t=";
    private static final String API_KEY = "&apikey=7ca9f0c2";

    public static String requestTitle(String title) throws IOException {

        Cache cache = Cache.getInstance();
        if(cache.isOnCache(title)){
            return cache.getMovieDescription(title);
        }

        GET_URL += title;
        GET_URL += API_KEY;

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success)
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            //System.out.println(title+"    ["+response.toString()+"]");
            GET_URL = "http://www.omdbapi.com/?t=";
            String resp = "["+response.toString()+"]" ;
            cache.addMovie(title, resp);
            return  resp;
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "Failed";
    }

}
