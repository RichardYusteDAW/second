package fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCommand {

    private long id;
    private String name;
    private String nationality;
    private String biography_en;
    private String biography_es;
    private Integer birthYear;
    private Integer deathYear;

    // Constructor
    public AuthorCommand(String name, String nationality, String biography_en, String biography_es, Integer birthYear,
            Integer deathYear) {
        this.name = name;
        this.nationality = nationality;
        this.biography_en = biography_en;
        this.biography_es = biography_es;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }
}