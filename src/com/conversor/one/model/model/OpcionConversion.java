package com.conversor.one.model.model;

import com.conversor.one.model.service.ConversorService;
import java.io.IOException;

public class OpcionConversion {
    private String mensajeConfirma;
    private String monedaOrigen;
    private String monedaDestino;

    public OpcionConversion(String mensajeConfirma, String monedaOrigen, String monedaDestino) {
        this.mensajeConfirma = mensajeConfirma;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
    }
    public void ejecutarConversion(double cantidad, ConversorService conversorService) throws IOException, InterruptedException {
        System.out.println(mensajeConfirma);
        double resultado = conversorService.convertir(this.monedaOrigen, this.monedaDestino, cantidad);
        System.out.printf("La cantidad : [%s] %s Equivale a: [%s] %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
    }
}
