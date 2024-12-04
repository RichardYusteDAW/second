package fpmislata.examen.c_domain._2service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String isbn;
    private String title_es;
    private String title_en;
    private String synopsis_es;
    private String synopsis_en;
    private Float price;
    private String cover;

    public String getTitle() {
        return title_es;
    }
}