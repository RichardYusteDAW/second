package fpmislata.examen.d_persistence.zdao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fpmislata.examen.d_persistence.zdao.impl.model.MovieDaoModel;

public interface MovieJpa extends JpaRepository<MovieDaoModel, Integer> {

}