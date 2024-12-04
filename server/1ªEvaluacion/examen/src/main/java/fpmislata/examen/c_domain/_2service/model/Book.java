package fpmislata.examen.c_domain._2service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    Integer id;
    String isbn;
    String title_es;
    String title_en;
    String synopsis_es;
    String synopsis_en;
    Float price;
    String cover;

    public String getTitle() {
        return title_es;
    }

    public String getSynopsis() {
        return synopsis_es;
    }
}