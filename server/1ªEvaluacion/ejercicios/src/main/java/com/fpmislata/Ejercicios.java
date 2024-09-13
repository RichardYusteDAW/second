package com.fpmislata;

import java.util.List;

// Ejercicio 1
// Dada una lista de enteros, usa programación funcional para calcular la suma de todos los elementos.
public class Ejercicios {

    public int sumaEnteros(List<Integer> listaEnteros) {
        return listaEnteros
                .stream()
                .reduce(0, Integer::sum);
    }
}