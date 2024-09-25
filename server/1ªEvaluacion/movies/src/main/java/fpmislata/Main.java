package fpmislata;

import java.util.UUID;

import fpmislata.domain.model.Actor;
import fpmislata.domain.model.Director;
import fpmislata.domain.model.Movie;

public class Main {

    public static void main(String[] args) {
        Director director = new Director(UUID.randomUUID(), "Steven", "Spielberg");
        Actor actor = new Actor(UUID.randomUUID(), "Tom", "Hanks");
        Movie movie = new Movie(UUID.randomUUID(), "Saving Private Ryan", 1998);
        System.out.println("Director: " + director.toString());
        System.out.println("Actor: " + actor.toString());
        System.out.println("Movie: " + movie.toString());
    }
}