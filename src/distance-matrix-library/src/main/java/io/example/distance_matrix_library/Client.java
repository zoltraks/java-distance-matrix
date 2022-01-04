package io.example.distance_matrix_library;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.net.UnknownHostException;

public class Client {

    private String apiKey = "";

    public Client withApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public Client makeExampleRequest() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String url = makeExampleUrl(this.apiKey);
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (SSLException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = null;
        if (response != null) {
            try {
                json = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Utility.maybeJson(json)) {
            System.out.println(">->\n" + json.trim() + "\n<-<");
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            Body body = gson.fromJson(json, Body.class);
            System.out.println(gson.toJson(body));
        }
        return this;
    }

    private String makeExampleUrl(String apiKey) {
        String templateUrl;
        String valueForOrigins;
        String valueForDestinations;
        valueForOrigins = "53.4428779947609, 14.537654260408527"; // Pomnik Czynu Polaków, Juliana Fałata, 70-496 Szczecin
        valueForDestinations = "52.23194966713661, 21.00602719176854"; // Pałac Kultury i Nauki, Plac Defilad 1, 00-901 Warszawa
        templateUrl = "https://api.distancematrix.ai/maps/api/distancematrix/json?origins=%s&destinations=%s&departure_time=now&key=%s";
        String url = String.format(templateUrl, valueForOrigins, valueForDestinations, apiKey);
        return url;
    }

}
