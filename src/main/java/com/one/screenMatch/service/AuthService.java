package com.one.screenMatch.service;

public class AuthService {
    private final TMDBClient client = new TMDBClient();

    public String autenticar() {
        return client.get("/authentication");
    }

}
