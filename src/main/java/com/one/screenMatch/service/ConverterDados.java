package com.one.screenMatch.service;

import com.one.screenMatch.model.SeriesDetails;
import tools.jackson.databind.ObjectMapper;

public class ConverterDados implements IConverterDados{

    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        return mapper.readValue(json, classe);
    }
}
