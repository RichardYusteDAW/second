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

import fpmislata.examen.b_presentation.admin.mapper.DirectorMapper;
import fpmislata.examen.b_presentation.admin.model.DirectorSimple;
import fpmislata.examen.b_presentation.common.Paginator;
import fpmislata.examen.c_domain._1usecase.admin.director.interfaces.DirectorCreateUseCase;
import fpmislata.examen.c_domain._1usecase.admin.director.interfaces.DirectorDeleteUseCase;
import fpmislata.examen.c_domain._1usecase.admin.director.interfaces.DirectorUpdateUseCase;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorFindAllUseCase;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorFindByIdUseCase;
import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(DirectorController.ENDPOINT)
public class DirectorController {

    private final DirectorFindAllUseCase directorFindAllUseCase;
    private final DirectorFindByIdUseCase directorFindByIdUseCase;
    private final DirectorCreateUseCase directorCreateUseCase;
    private final DirectorUpdateUseCase directorUpdateUseCase;
    private final DirectorDeleteUseCase directorDeleteUseCase;

    @Value("${url}")
    private String URL;
    public static final String ENDPOINT = "/api/admin/directors";

    @GetMapping()
    public ResponseEntity<Paginator<DirectorSimple>> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        ListWithCount<Director> directorsListWithCount = directorFindAllUseCase.execute(page - 1, size);
        List<DirectorSimple> directorSimpleList = DirectorMapper.INSTANCE
                .toDirectorSimpleList(directorsListWithCount.list());
        Paginator<DirectorSimple> paginator = new Paginator<>(directorSimpleList, directorsListWithCount.count(), page,
                size,
                URL + ENDPOINT);

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorSimple> findById(@PathVariable Integer id) {
        Director director = directorFindByIdUseCase.execute(id);
        DirectorSimple directorSimple = DirectorMapper.INSTANCE.toDirectorSimple(director);

        return ResponseEntity.ok(directorSimple);
    }

    @PostMapping()
    public ResponseEntity<DirectorSimple> create(@RequestBody Director director) {
        Director directorCreated = directorCreateUseCase.execute(director);
        DirectorSimple directorSimple = DirectorMapper.INSTANCE.toDirectorSimple(directorCreated);

        return new ResponseEntity<>(directorSimple, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorSimple> update(@PathVariable Integer id, @RequestBody Director director) {
        director.setId(id);
        Director directorUpdated = directorUpdateUseCase.execute(director);
        DirectorSimple directorSimple = DirectorMapper.INSTANCE.toDirectorSimple(directorUpdated);

        return ResponseEntity.ok(directorSimple);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        directorDeleteUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }
}