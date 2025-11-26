package com.one.screenMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class MyCommandLineRunner implements CommandLineRunner {
    /**
     * A ‘interface’ CommandLineRunner permite que executemos alguma ação logo após a inicialização
     * da nossa aplicação, pode ser útil se quisermos carregar alguns dados no nosso banco de dados
     * logo no início da nossa aplicação.
     *
     * A 'interface' CommandLineRunner representa uma tarefa a ser executada após a inicialização do
     * Spring Boot, ou seja, permite definir código para ser executado automaticamente quando o ‘app’
     * é iniciado.
     *
     * É uma 'interface' bem versátil podendo ser usada em diversas situações, como carregar dados para
     * um banco de dados, iniciar recursos, como conexões de rede e checar a integridade de determinados
     * componentes ou serviços com os quais a aplicação irá interagir.
     *
     */

    @Override
    public void run(String... args) throws Exception {
        /**
         * Sobrescrevemos o método run recebido da CommandLineRunner
         *  Inserimos a ação que desejamos que seja executada logo depois que a aplicação for iniciada,
         *  nesse caso, apenas printamos Aula 0...
         */
        System.out.println("Aula 0 | Spring Boot sem web");
    }
}
