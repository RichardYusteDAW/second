package fpmislata.bookstore.c_domain.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private long id;
    private String isbn;
    private String titleEs;
    private String titleEn;
    private String synopsisEs;
    private String synopsisEn;
    private BigDecimal price;
    private float discount;
    private String cover;
    private Publisher publisher;
    private Category category;
    private List<Genre> genres;
    private List<Author> authors;

    // Constructor
    public Book(String isbn, String titleEs, String titleEn, String synopsisEs, String synopsisEn, BigDecimal price,
            float discount, String cover, Publisher publisher, Category category, List<Genre> genres,
            List<Author> authors) {
        this.isbn = isbn;
        this.titleEs = titleEs;
        this.titleEn = titleEn;
        this.synopsisEs = synopsisEs;
        this.synopsisEn = synopsisEn;
        this.price = price;
        this.discount = discount;
        this.cover = cover;
        this.publisher = publisher;
        this.category = category;
        this.genres = genres;
        this.authors = authors;
    }
}