package com.one.screenMatch.service;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class TMDBClient {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    String baseUrlAPI;
    String credential;

    public TMDBClient() {

        // Carrega o arquivo .env, que contém configurações sensíveis da API
        Dotenv dotenv = Dotenv.load();
        this.baseUrlAPI = dotenv.get("TMDB_BASE_URL");
        this.credential = dotenv.get("AUTH_TOKEN");
    }

    public String get(String route) {

        // Criação de um cliente HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrlAPI + route))
                .header("Authorization", credential)
                .GET()
                .build();

        return send(request);
    }

    public String post(String route, String body) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrlAPI + route))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return send(request);
    }

    private String send(HttpRequest request) {
        try {
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            // IOException: problemas de comunicação (rede, servidor, etc.)
            // InterruptedException: se a thread for interrompida durante a espera da resposta.
            // Ambos são encapsulados em RuntimeException para simplificar o tratamento.
            throw new RuntimeException(e);
        }
    }


}
