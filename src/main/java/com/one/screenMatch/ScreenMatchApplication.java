package com.one.screenMatch;

import com.one.screenMatch.model.SeriesDetails;
import com.one.screenMatch.model.SeriesResponse;
import com.one.screenMatch.service.AuthService;
import com.one.screenMatch.service.ConverterDados;
import com.one.screenMatch.service.SearchSerieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        var consumoAPI = new AuthService();
        consumoAPI.autenticar();

        SearchSerieService serie = new SearchSerieService();
        String querySerie = "the office";

        // Json retornado pela API
        String json = serie.buscarSerie(querySerie);
        // System.out.println(json);

        ConverterDados conversor = new ConverterDados();

        SeriesResponse dados = conversor.obterDados(json, SeriesResponse.class);

        System.out.println("Resultados encontrados: " + dados.results().size());

        for (SeriesDetails s : dados.results()) {
            System.out.println("==================================================");
            System.out.println("Título: " + s.titulo());
            System.out.println("Lançamento: " + s.anoLancamento());
            System.out.println("Resumo:");
            System.out.println(s.resumo());
            System.out.println("==================================================");

        }

    }
}


