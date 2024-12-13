package fpmislata.bookstore.c_domain._2service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    private long id;
    private String name;
    private String slug;
}