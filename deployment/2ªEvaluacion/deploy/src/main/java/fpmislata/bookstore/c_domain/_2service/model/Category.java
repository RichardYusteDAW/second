package fpmislata.bookstore.c_domain._2service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private long id;
    private String nameEs;
    private String nameEn;
    private String slug;
}