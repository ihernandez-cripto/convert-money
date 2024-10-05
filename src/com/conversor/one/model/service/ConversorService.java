package com.conversor.one.model.service;

import com.conversor.one.model.model.RespuestaAPI;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {

    public Double convertir(String monedaOrigen, String monedaDestino, Double cantidad) throws IOException, InterruptedException {
            // Construir la URL completa
            String url = "https://v6.exchangerate-api.com/v6/19399a7ab3701eacf148d994/pair/" + monedaOrigen + "/" + monedaDestino + "/" + cantidad;
            // Crear un cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String respuestaJson = response.body();
            Gson gson = new Gson();
            RespuestaAPI recibeJason = gson.fromJson(respuestaJson, RespuestaAPI.class);
            return recibeJason.conversion_rate();
    }
}

