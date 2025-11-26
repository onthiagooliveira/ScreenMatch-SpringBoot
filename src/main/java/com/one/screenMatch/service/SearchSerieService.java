package com.one.screenMatch.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Classe responsável por realizar as requisições HTTP para API TMDB.
 * Esse serviço executa a requisição a rota URL fornecida e retorna o corpo
 * da reposta em formato {@code String}, geralmente JSON.
 */
public class SearchSerieService {
    private final TMDBClient client = new TMDBClient();

    public String buscarSerie(String serie) {
        String encoded = URLEncoder.encode(serie, StandardCharsets.UTF_8);

        String endpoint = "search/tv?query=" + encoded
                + "&include_adult=false"
                + "&language=pt-BR"
                + "&page=1";

        return client.get(endpoint);
    }
}
