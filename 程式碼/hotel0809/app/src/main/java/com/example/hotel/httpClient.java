package com.example.hotel;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class httpClient {
    //String api="https://localhost:44329/api/";
    String api="http://163.17.135.176/rfid_api/api/";

    public String get(String http){
        HttpURLConnection connection = null;
        String result = "";

        try {
            URL url = new URL(api+http);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");


            InputStream inputStream = connection.getInputStream();
            int status = connection.getResponseCode();
            Log.d("test", String.valueOf(status));
            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader in = new BufferedReader(reader);

                String line = "";
                while ((line = in.readLine()) != null) {
                    result = line;
                }
            } else {
                result = "Did not work!";
            }
            Log.d("http-get ", result);


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public String Post(String http ,String  json ){
        HttpURLConnection connection = null;
        String result = "";

        try {

            URL url = new URL(api+http);



            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            catch (IOException e){
                Log.e("post",e.toString());
            }

            InputStream inputStream = connection.getInputStream();
            int status = connection.getResponseCode();
            Log.d("test", String.valueOf(status));
            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader in = new BufferedReader(reader);

                String line = "";
                while ((line = in.readLine()) != null) {
                    result = line;
                }
            } else {
                result = "Did not work!";
            }
            Log.d("http-get ", result);


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
