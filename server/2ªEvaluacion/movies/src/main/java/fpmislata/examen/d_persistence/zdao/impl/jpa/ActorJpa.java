package fpmislata.examen.d_persistence.zdao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fpmislata.examen.d_persistence.zdao.impl.model.ActorDaoModel;

public interface ActorJpa extends JpaRepository<ActorDaoModel, Integer> {

    @Query(value = "SELECT a.* FROM Actor a " +
            "JOIN Movie_Actor ma ON ma.actor_id = a.id " +
            "WHERE ma.movie_id = :id", nativeQuery = true)

    List<ActorDaoModel> findAllByMovieId(Integer id);

    @Query(value = "SELECT a.* FROM Actor a " +
            "WHERE a.id IN (:ids)", nativeQuery = true)

    List<ActorDaoModel> findAllByIds(List<Integer> ids);
}