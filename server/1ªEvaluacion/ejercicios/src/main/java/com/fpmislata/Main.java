package com.fpmislata;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> listaEnteros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Ejercicios ejercicios = new Ejercicios();
        System.out.println(ejercicios.sumaEnteros(listaEnteros));
    }
}