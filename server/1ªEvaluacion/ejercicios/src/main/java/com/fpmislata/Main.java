package com.fpmislata;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Ejercicios exercises = new Ejercicios();

        Character character = 'p';
        Integer value = 7;
        List<Integer> listIntegers = List.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 9, 10);
        List<String> listStrings = List.of("paco", "pepe", "juan", "luis", "jose", "carlos", "javier", "raul");

        System.out.println("1º ejercicio: " + exercises.sumInteger(listIntegers));
        System.out.println("2º ejercicio: " + exercises.getEvenIntegers(listIntegers));
        System.out.println("3º ejercicio: " + exercises.toUpperCase(listStrings));
        System.out.println("3Bº ejercicio: " + exercises.capitalize(listStrings));
        System.out.println("4º ejercicio: " + exercises.getMaxInteger(listIntegers));
        System.out.println("5º ejercicio: " + exercises.countGreaterThan(listIntegers, value));
        System.out.println("6º ejercicio: " + exercises.concat(listStrings));
        System.out.println("7º ejercicio: " + exercises.squared(listIntegers));
        System.out.println("8º ejercicio: " + exercises.removeDuplicates(listIntegers));
        System.out.println("9º ejercicio: " + exercises.getFirstGreaterThan(listIntegers, value));
        System.out.println("10º ejercicio: " + exercises.countStartWith(listStrings, character));
    }
}