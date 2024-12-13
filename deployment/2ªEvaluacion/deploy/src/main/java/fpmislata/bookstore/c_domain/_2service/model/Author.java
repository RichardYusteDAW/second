package fpmislata.bookstore.c_domain._2service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private Long id;
    private String name;
    private String nationality;
    private String biographyEs;
    private String biographyEn;
    private Integer birthYear;
    private Integer deathYear;

    // constructor
    public Author(String name, String nationality, String biographyEs, String biographyEn, Integer birthYear,
            Integer deathYear) {
        this.name = name;
        this.nationality = nationality;
        this.biographyEs = biographyEs;
        this.biographyEn = biographyEn;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }
}