package edu.escuelaing.arep.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase encargada de hacer la consulta hacia las APIS externas
 */
public class APIConnection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "http://www.omdbapi.com/?t=";
    private static final String API_KEY = "&apikey=7ca9f0c2";

    /***
     * Realiza la consulta hacia la API externa y toma su JSON para ponerlo en formato de STRING
     * @param jquery Titulo de la pelicula a consultar en la API externa
     * @return Retorna la descripción de la pelicula en formato de JSON interpretado como STRING
     * @throws IOException Exception
     */
    public static String requestTitle(String jquery) throws IOException {

        Cache cache = Cache.getInstance();
        if(cache.isOnCache(jquery)){
            return cache.getMovieDescription(jquery);
        }

        GET_URL += jquery;
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
            GET_URL = "http://www.omdbapi.com/?t=";
            String resp = "["+response.toString()+"]" ;
            cache.addMovie(jquery, resp);
            return  resp;
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "Failed";
    }

}
