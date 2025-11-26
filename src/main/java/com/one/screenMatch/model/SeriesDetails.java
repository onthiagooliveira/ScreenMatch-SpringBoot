package com.one.screenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesDetails(
        @JsonProperty("name") String titulo,
        @JsonAlias("overview") String resumo,
        @JsonAlias({"first_air_date", "release_date"}) String anoLancamento,
        @JsonAlias("vote_average") Double avaliacao,
        @JsonAlias("vote_count") Integer numeroAvaliacoes,
        @JsonAlias("media_type") String tipo
)
{}
