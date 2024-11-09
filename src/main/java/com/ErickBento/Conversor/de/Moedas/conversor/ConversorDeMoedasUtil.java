package com.ErickBento.Conversor.de.Moedas.conversor;

import com.ErickBento.Conversor.de.Moedas.DTOs.ConversaoMoedaDTO;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoedasUtil {

    private static final String API_KEY = "3faaecc6fb2033f0e28af35f";

    public static double obterTaxaDeCambio(String base, String destino) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + destino;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // Conversão do JSON para a classe DTO usando Gson
            Gson gson = new Gson();
            ConversaoMoedaDTO conversao = gson.fromJson(responseBody, ConversaoMoedaDTO.class);

            if ("success".equals(conversao.result())) {
                return conversao.conversion_rate();
            } else {
                System.out.println("Falha ao obter a taxa de câmbio: " + conversao.result());
            }
        } catch (Exception e) {
            System.out.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
        }

        return -1; // Retorna -1 para indicar falha
    }

    public static void converterMoeda(String base, String destino, double quantidade) {
        double taxa = obterTaxaDeCambio(base, destino);
        if (taxa != -1) {
            double resultado = quantidade * taxa;
            System.out.printf("Resultado: %.2f %s = %.2f %s%n", quantidade, base, resultado, destino);
        } else {
            System.out.println("Falha ao obter a taxa de câmbio.");
        }
    }
}