package com.example.starwarsapi;
import android.net.Uri;
import android.os.Bundle;
import android.util.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NetworkUtils {
    private static final String URL_API = "https://localhost:44310/Api/Atracao";
    String artJSON = null;
    static String url = null;

    static Bundle mostraInfo(int id)
    {
        HttpURLConnection connec = null;
        BufferedReader reader = null;
        String artJSON = null;
        try {
            Uri buildURI = Uri.parse(URL_API).buildUpon()
                    .appendQueryParameter("id",String.valueOf(id))
                    .build();
            URL requestUrl = new URL(buildURI.toString());
            url = buildURI.toString();
            connec = (HttpURLConnection) requestUrl.openConnection();
            connec.setRequestMethod("GET");
            connec.connect();

            InputStream inputStream = connec.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder();
            String line;
            while((line =reader.readLine()) != null)
            {
                builder.append(line);
                builder.append("/n");
            }
            if (builder.length() == 0)
            {
                return null;
            }
            artJSON = builder.toString();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (ProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            connec.disconnect();
        }
        Bundle artInfo = new Bundle();
        artInfo.putString("arts", artJSON);
        return artInfo;
    }

    static void adicionaInfo(Atracoes atracoes){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String atracaoJSONString = null;
        try {
            Uri builtURI;
            if(atracoes == null){
                builtURI = Uri.parse(URL_API).buildUpon()
                        .build();
            }
            else {
                String url1 = URL_API;
                //Construção da URI de Busca
                builtURI = Uri.parse(url1).buildUpon()
                        .build();
            }

            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            InputStreamReader inputStreamReader =
                    new InputStreamReader(inputStream, "UTF-8");

            JsonReader jsonReader = new JsonReader(inputStreamReader);
            jsonReader.beginObject(); // Start processing the JSON object
            while (jsonReader.hasNext()) { // Loop through all keys
                String url = jsonReader.nextName(); // Fetch the next key
                if (url.equals("URL_API")) { // Check if desired key
                    Gson gson = new Gson();
                    String atracoesAdd = gson.toJson(atracoes);
                    // Fetch the value as a String
                    atracoesAdd = jsonReader.nextString();

                    // Do something with the value
                    // ...

                    break; // Break out of the loop
                } else {
                    jsonReader.skipValue(); // Skip values of other keys
                }
            }
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void updateInfo(Atracoes atracoes){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String atracoesrJSONString = null;



        try {
            Uri builtURI;
            if(atracoes == null){
                builtURI = Uri.parse(URL_API).buildUpon()
                        .build();
            }
            else {
                String url1 = URL_API;
                //Construção da URI de Busca
                builtURI = Uri.parse(url1).buildUpon()
                        .build();


            }

            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

            JsonReader jsonReader = new JsonReader(inputStreamReader);
            jsonReader.beginObject(); // Start processing the JSON object
            while (jsonReader.hasNext()) { // Loop through all keys
                String url = jsonReader.nextName(); // Fetch the next key
                if (url.equals("URL_API")) { // Check if desired key
                    Gson gson = new Gson();
                    String atracoesUpdate = gson.toJson(atracoes);
                    // Fetch the value as a String
                    atracoesUpdate = jsonReader.nextString();


                    break; // Break out of the loop
                } else {
                    jsonReader.skipValue(); // Skip values of other keys
                }
            }
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("SET");
            urlConnection.connect();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void deleteInfo(String atracoes){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String atracoesJSONString = null;



        try {
            Uri builtURI;
            if(atracoes == null){
                builtURI = Uri.parse(URL_API).buildUpon()
                        .build();
            }
            else {
                String url1 = URL_API;
                //Construção da URI de Busca
                builtURI = Uri.parse(url1).buildUpon()
                        .build();


            }

            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            InputStreamReader inputStreamReader =
                    new InputStreamReader(inputStream, "UTF-8");

            JsonReader jsonReader = new JsonReader(inputStreamReader);
            jsonReader.beginObject(); // Start processing the JSON object
            while (jsonReader.hasNext()) { // Loop through all keys
                String url = jsonReader.nextName(); // Fetch the next key
                if (url.equals("URL_API")) { // Check if desired key
                    Gson gson = new Gson();
                    String atracoesUpdate = gson.toJson(atracoes);
                    // Fetch the value as a String
                    atracoesUpdate = jsonReader.nextString();

                    // Do something with the value
                    // ...

                    break; // Break out of the loop
                } else {
                    jsonReader.skipValue(); // Skip values of other keys
                }
            }
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("DELETE");
            urlConnection.connect();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

