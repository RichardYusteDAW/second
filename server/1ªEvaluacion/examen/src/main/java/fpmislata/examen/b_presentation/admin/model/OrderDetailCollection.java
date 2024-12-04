package fpmislata.examen.b_presentation.admin.model;

public record OrderDetailCollection(
        Integer quantity,
        Float price,
        BookCollection book) {
}