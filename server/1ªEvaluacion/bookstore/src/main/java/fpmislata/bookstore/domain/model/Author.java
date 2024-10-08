package fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private long id;
    private String name;
    private String nationality;
    private String biography;
    private Integer birthYear;
    private Integer deathYear;

    // Constructor
    public Author(String name, String nationality, String biography, Integer birthYear, Integer deathYear) {
        this.name = name;
        this.nationality = nationality;
        this.biography = biography;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }
}