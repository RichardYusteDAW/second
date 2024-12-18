package fpmislata.examen.c_domain._2service.model;

import java.util.List;

import fpmislata.examen.a_common.exception.ResourceAlreadyExistsException;
import fpmislata.examen.a_common.locale.LanguageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Integer id;
    private String titleEn;
    private String titleEs;
    private String descriptionEn;
    private String descriptionEs;
    private Director director;
    private List<Actor> actors;

    public String getTitle() {
        String language = LanguageUtils.getCurrentLanguage();
        return language.equals("en") ? titleEn : titleEs;
    }

    public String getDescription() {
        String language = LanguageUtils.getCurrentLanguage();
        return language.equals("en") ? descriptionEn : descriptionEs;
    }

    public void addActor(Actor actor) {
        if (getActors().contains(actor)) {
            throw new ResourceAlreadyExistsException("Actor " + actor.getName() + "already exists");
        }
        actors.add(actor);
    }
}