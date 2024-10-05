package com.conversor.one.model.service;

import com.conversor.one.model.model.OpcionConversion;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class ConvertMoney {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner opcion = new Scanner(System.in);
        Scanner divisas = new Scanner(System.in);
        String menu = """
                ******* Bienvenido al conversor de Moneda *******
                1. Peso Colombiano (COP) a Dollar (US).
                2. Dollar (US) - Peso Colombiano (COP).
                3. Peso Argentino () - Dollar.
                4. Dollar (USD) - Peso Argentino ().
                5. Real Brasilero () - Dollar (USD).
                6. Dollar (USD) - Real Brasilero ().
                7. Salir.
                """;

        List<OpcionConversion> opciones = List.of(
            new OpcionConversion("Elegiste Peso Colombiano (COP) - Dollar (USD).", "COP", "USD"),
            new OpcionConversion("Elegiste Dollar (USD) - Peso Colombiano (COP).", "USD", "COP"),
            new OpcionConversion("Elegiste Peso Argentino (ARS) - Dollar (USD).", "ARS", "USD"),
            new OpcionConversion("Elegiste Dollar (USD) - Peso Argentino (ARS).", "USD", "ARS"),
            new OpcionConversion("Elegiste Real Brazilero (BRL) - Dollar (USD).", "BRL", "USD"),
            new OpcionConversion("Elegiste Dollar (USD) - Real Brazilero (BRL).", "USD", "BRL"),
            new OpcionConversion("Elegiste Salir", null, null)
        );
        double cantidad;
        int traerDivisa;
        do {
          do {
              out.println(menu);
              out.println("Selecciona una opción (1-" + opciones.size() + "):");
              while (!opcion.hasNextInt()) {
                  out.println("Por favor, ingresa un número entero válido.");
                  opcion.next();
              }
              traerDivisa = opcion.nextInt();
          } while (traerDivisa < 1 || traerDivisa > opciones.size());
            if (traerDivisa == opciones.size()) {
                out.println("Saliendo...");
            } else {
                out.println("Cantidad de divisas a convertir: ");
                cantidad = divisas.nextDouble();
                opciones.get(traerDivisa - 1).ejecutarConversion(cantidad, new ConversorService());
            }
        }while (traerDivisa >= 1 && traerDivisa < opciones.size());
   }
}
