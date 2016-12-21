package com.example.marcuschiu.showcase.background;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcus.chiu on 12/20/16.
 */

public class HttpURLConnectionHelper {

    public String executeGet(String targetURL) {
        String responseString = "";

        try {
            URL obj = new URL(targetURL);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            connection.setRequestMethod("GET");
            // optional default is false
            connection.setDoOutput(false);
            // optional default is true
            connection.setDoInput(true);

            // Response Code
            int responseCode = connection.getResponseCode();
            System.out.println("response code: " + responseCode);

            // Get Response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            responseString = response.toString();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseString;
    }

    public String executePost(String targetURL, HashMap<String, String> params) {
        String responseString = "";

        try
        {
            URL obj = new URL(targetURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setReadTimeout(10000);
            con.setConnectTimeout(15000);
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);

            if (params != null) {
                StringBuilder outpar = new StringBuilder();
                boolean first = true;
                for (Map.Entry<String, String> e: params.entrySet()) {
                    if (first)
                        first = false;
                    else
                        outpar.append("&");

                    outpar.append(URLEncoder.encode(e.getKey(), "UTF-8"));
                    outpar.append("=");
                    outpar.append(URLEncoder.encode(e.getValue(), "UTF-8"));
                }

                OutputStream os = con.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(outpar.toString());
                writer.flush();
                writer.close();
                os.close();
            }

            con.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();

            responseString = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseString;
    }
}
