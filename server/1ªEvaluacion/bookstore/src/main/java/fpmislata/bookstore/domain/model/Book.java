package fpmislata.bookstore.domain.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String ISBN;
    private String title;
    private String synopsis;
    private BigDecimal price;
    private Float discount;
    private String cover;
    private Publisher publisher;
    private Category category;
    private List<Author> authorList;
    private List<Genre> genreList;
}