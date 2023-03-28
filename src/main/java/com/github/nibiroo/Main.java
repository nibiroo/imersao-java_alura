package com.github.nibiroo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        //
        String urlApiMovie = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(urlApiMovie);

        var httpClient = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String body = httpResponse.body();

        System.out.println(body);
        //
        System.out.println();
        System.out.println();
        //
        var jsonParser = new JsonParser();
        List<Map<String, String>> moviesList = jsonParser.parse(body);

        System.out.println(moviesList.size());
        System.out.println(moviesList.get(9));
        //
        System.out.println();
        System.out.println();
        //
        for (Map<String, String> movie : moviesList) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
        }
        //
    }
}