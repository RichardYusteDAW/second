package fpmislata.bookstore.c_domain._2service.model;

import java.math.BigDecimal;
import java.util.List;

import fpmislata.bookstore.a_common.locale.LanguageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;
    private String isbn;
    private String titleEs;
    private String titleEn;
    private String synopsisEs;
    private String synopsisEn;
    private BigDecimal price;
    private float discount;
    private String cover;
    private Publisher publisher;
    private List<Author> authors;

    public String getTitle() {
        String language = LanguageUtils.getCurrentLanguage();
        if (language.equals("en")) {
            return titleEn;
        } else {
            return titleEs;
        }
    }

    public String getSynopsis() {
        String language = LanguageUtils.getCurrentLanguage();
        if (language.equals("en")) {
            return synopsisEn;
        } else {
            return synopsisEs;
        }
    }
}