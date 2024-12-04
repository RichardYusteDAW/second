package fpmislata.examen.b_presentation.admin.model;

import java.sql.Date;

public record OrderCollection(
        Integer id,
        Date order_date,
        Date delivery_date,
        String status,
        Float total) {
}