package com.one.screenMatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Classe que representa os dados recebidos dos JSON ao realizar a busca
 * pela série.
 * <p>
 * @param page
 * @param results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesResponse(
        int page,
        List<SeriesDetails> results
) {}
