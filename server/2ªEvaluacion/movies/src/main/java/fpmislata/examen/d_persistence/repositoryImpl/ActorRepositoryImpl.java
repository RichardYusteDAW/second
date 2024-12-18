package fpmislata.examen.d_persistence.repositoryImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._3repository.ActorRepository;
import fpmislata.examen.d_persistence.zdao.interfaces.ActorDao;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ActorRepositoryImpl implements ActorRepository {

    private final ActorDao actorDao;

    public List<Actor> findAllById(Integer[] actorsIds) {
        return actorDao.findAllById(actorsIds);
    }
}