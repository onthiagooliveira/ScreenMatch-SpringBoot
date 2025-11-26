package com.one.screenMatch.service;

public interface IConverterDados {

    <T> T obterDados(String json, Class<T> classe);

}
