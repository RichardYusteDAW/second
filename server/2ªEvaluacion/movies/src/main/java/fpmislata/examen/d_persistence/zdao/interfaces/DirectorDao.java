package fpmislata.examen.d_persistence.zdao.interfaces;

import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.Director;

public interface DirectorDao extends GenericDao<Director> {

    Optional<Director> findByMovieId(Integer movieId);
}