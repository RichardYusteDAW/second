package fpmislata.examen.b_presentation.admin.model;

import java.util.List;

public record MovieComplete(
                Integer id,
                String title,
                String description,
                DirectorSimple director,
                List<ActorSimple> actors) {
}