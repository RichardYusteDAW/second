package fpmislata.bookstore._3domain.admin._1model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    private long id;
    private String nameEs;
    private String nameEn;
    private String slug;
}