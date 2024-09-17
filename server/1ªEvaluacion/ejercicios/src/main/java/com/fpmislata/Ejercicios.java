package com.fpmislata;

import java.util.Comparator;
import java.util.List;

public class Ejercicios {

    // Ejercicio 1
    // Dada una lista de enteros, usa programación funcional para calcular la suma de todos los elementos.
    public Integer sumInteger(List<Integer> listIntegers) {
        return listIntegers
                .stream()
                //.reduce(0, Integer::sum);
                .reduce(0, (a, b) -> a + b);
    }

    // Ejercicio 2
    // Dada una lista de enteros, devuelve una lista con solo los números pares.
    public List<Integer> getEvenIntegers(List<Integer> listIntegers) {
        return listIntegers
                .stream()
                .filter(n -> n % 2 == 0)
                .toList();
    }

    // Ejercicio 3
    // Dada una lista de cadenas, convierte todas a mayúsculas usando programación funcional.
    public List<String> toUpperCase(List<String> listStrings) {
        return listStrings
                .stream()
                //.map(String::toUpperCase)
                .map(s -> s.toUpperCase())
                .toList();
    }

    // Ejercicio 3b
    // Ahora solo la primera letra de cada cadena.
    public List<String> capitalize(List<String> listStrings) {
        return listStrings
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .toList();
    }

    // Ejercicio 4
    // Dada una lista de enteros, usa programación funcional para encontrar el número máximo.
    public Integer getMaxInteger(List<Integer> listIntegers) {
        return listIntegers
                .stream()
                // .max(Comparator.naturalOrder())
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(null);
    }

    // Ejercicio 5
    // Dada una lista de enteros y un valor, cuenta cuántos elementos son mayores a ese valor.
    public long countGreaterThan(List<Integer> listIntegers, Integer value) {
        return listIntegers
                .stream()
                .filter((n) -> n > value)
                .count();
    }

    // Ejercicio 6
    // Dada una lista de cadenas, usa programación funcional para concatenar todas las cadenas en una sola.
    public String concat(List<String> listStrings) {
        return listStrings
                .stream()
                .reduce("", (a, b) -> a + b);
    }

    // Ejercicio 7
    // Dada una lista de enteros, devuelve una lista con los cuadrados de cada número.
    public List<Integer> squared(List<Integer> listIntegers) {
        return listIntegers
                .stream()
                .map(n -> n * n)
                .toList();
    }

    // Ejercicio 8
    // Dada una lista de enteros, elimina los duplicados usando programación funcional.
    public List<Integer> removeDuplicates(List<Integer> listIntegers) {
        return listIntegers
                .stream()
                .distinct()
                .toList();
    }

    // Ejercicio 9
    // Dada una lista de enteros, devuelve el primer número que sea mayor a un valor dado.
    public Integer getFirstGreaterThan(List<Integer> listIntegers, Integer value) {
        return listIntegers
                .stream()
                .filter(n -> n > value)
                .findFirst()
                .orElse(null);
    }

    public Integer getFirstGreaterThan2(List<Integer> listIntegers, Integer value) {
        return listIntegers
                .stream()
                .reduce((a, b) -> b > value ? b : a)
                .orElse(null);
    }

    // Ejercicio 10
    // Dada una lista de cadenas, cuenta cuántas empiezan con una letra específica.
    public long countStartWith(List<String> listStrings, Character character) {
        return listStrings
                .stream()
                .filter(str -> str.charAt(0) == character)
                .count();
    }
}