package fpmislata.bookstore.c_domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    private Integer id;
    private String nameEs;
    private String nameEn;
    private String slug;
}