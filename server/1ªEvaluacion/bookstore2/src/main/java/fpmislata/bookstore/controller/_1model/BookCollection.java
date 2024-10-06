package fpmislata.bookstore.controller._1model;

import java.math.BigDecimal;

public record BookCollection(String isbn, String title, BigDecimal price, Float discount, String cover) {
}