package fpmislata.domain.model;

import java.util.List;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Movie {

    // Attributes
    private UUID id;
    private String title;
    private Director director;
    private List<Actor> actorList;
    private Integer year;

    // Constructor
    public Movie(UUID id, String title, Integer year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }
}
