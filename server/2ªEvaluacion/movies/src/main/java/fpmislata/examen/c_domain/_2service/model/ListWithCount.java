package fpmislata.examen.c_domain._2service.model;

import java.util.List;

public record ListWithCount<T>(
                List<T> list,
                Long count) {
}