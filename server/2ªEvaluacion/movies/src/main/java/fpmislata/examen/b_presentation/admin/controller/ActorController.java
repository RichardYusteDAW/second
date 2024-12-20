package fpmislata.examen.b_presentation.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.examen.b_presentation.admin.mapper.ActorMapper;
import fpmislata.examen.b_presentation.admin.model.ActorSimple;
import fpmislata.examen.b_presentation.common.Paginator;
import fpmislata.examen.c_domain._1usecase.admin.actor.interfaces.ActorCreateUseCase;
import fpmislata.examen.c_domain._1usecase.admin.actor.interfaces.ActorDeleteUseCase;
import fpmislata.examen.c_domain._1usecase.admin.actor.interfaces.ActorUpdateUseCase;
import fpmislata.examen.c_domain._1usecase.common.actor.interfaces.ActorFindAllUseCase;
import fpmislata.examen.c_domain._1usecase.common.actor.interfaces.ActorFindByIdUseCase;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(ActorController.ENDPOINT)
public class ActorController {

        private final ActorFindAllUseCase actorFindAllUseCase;
        private final ActorFindByIdUseCase actorFindByIdUseCase;
        private final ActorCreateUseCase actorCreateUseCase;
        private final ActorUpdateUseCase actorUpdateUseCase;
        private final ActorDeleteUseCase actorDeleteUseCase;

        @Value("${url}")
        private String URL;
        public static final String ENDPOINT = "/api/admin/actors";

        @GetMapping()
        public ResponseEntity<Paginator<ActorSimple>> findAll(
                        @RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(required = false, defaultValue = "10") Integer size) {

                ListWithCount<Actor> actorsListWithCount = actorFindAllUseCase.execute(page - 1, size);
                List<ActorSimple> actorSimpleList = ActorMapper.INSTANCE
                                .toActorSimpleList(actorsListWithCount.list());
                Paginator<ActorSimple> paginator = new Paginator<>(actorSimpleList, actorsListWithCount.count(), page,
                                size,
                                URL + ENDPOINT);

                return ResponseEntity.ok(paginator);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ActorSimple> findById(@PathVariable Integer id) {
                Actor actor = actorFindByIdUseCase.execute(id);
                ActorSimple actorSimple = ActorMapper.INSTANCE.toActorSimple(actor);

                return ResponseEntity.ok(actorSimple);
        }

        @PostMapping()
        public ResponseEntity<ActorSimple> create(@RequestBody Actor actor) {
                Actor actorCreated = actorCreateUseCase.execute(actor);
                ActorSimple actorSimple = ActorMapper.INSTANCE.toActorSimple(actorCreated);

                return new ResponseEntity<>(actorSimple, HttpStatus.CREATED);

        }

        @PutMapping("/{id}")
        public ResponseEntity<ActorSimple> update(@PathVariable Integer id, @RequestBody Actor actor) {
                actor.setId(id);
                Actor actorUpdated = actorUpdateUseCase.execute(actor);
                ActorSimple actorSimple = ActorMapper.INSTANCE.toActorSimple(actorUpdated);

                return ResponseEntity.ok(actorSimple);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
                actorDeleteUseCase.execute(id);

                return ResponseEntity.noContent().build();
        }
}