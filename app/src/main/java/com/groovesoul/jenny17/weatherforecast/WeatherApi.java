package com.groovesoul.jenny17.weatherforecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jenny17 on 2017/05/04.
 */

public class WeatherApi {

    private static final String API_ENDPOINT
            = "http://weather.livedoor.com/forecast/webservice/json/v1?city=";
    public static String getWeather(String cityId) throws IOException {

            URL uri = new URL(API_ENDPOINT + cityId);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();

            StringBuilder sb = new StringBuilder();

            try {
                 BufferedReader br = new BufferedReader(
                         new InputStreamReader(connection.getInputStream()));

                 String line;
                 while ((line = br.readLine()) != null){
                    sb.append(line);
                }
            } finally {
                connection.disconnect();
            }

            return sb.toString();
    }
}
