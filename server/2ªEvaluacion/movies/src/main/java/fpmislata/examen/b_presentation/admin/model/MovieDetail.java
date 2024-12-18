package fpmislata.examen.b_presentation.admin.model;

import java.util.List;

public record MovieDetail(
                Integer id,
                String title,
                String description,
                DirectorCollection director,
                List<ActorCollection> actors) {
}