package fpmislata.examen.b_presentation.admin.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.examen.b_presentation.admin.mapper.DirectorMapper;
import fpmislata.examen.b_presentation.admin.model.DirectorCollection;
import fpmislata.examen.b_presentation.common.Paginator;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorFindByIdUseCase;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorGetAllUseCase;
import fpmislata.examen.c_domain._2service.model.Director;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(DirectorController.ENDPOINT)
public class DirectorController {

    private final DirectorGetAllUseCase directorFindAllUseCase;
    private final DirectorFindByIdUseCase directorFindByIdUseCase;

    @Value("${url}")
    private String URL;
    public static final String ENDPOINT = "/api/admin/directors";

    @GetMapping()
    public ResponseEntity<Paginator<DirectorCollection>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        List<Director> directors = directorFindAllUseCase.execute(page - 1, size);
        List<DirectorCollection> directorCollectionList = DirectorMapper.INSTANCE.toDirectorCollectionList(directors);
        Paginator<DirectorCollection> paginator = new Paginator<>(directorCollectionList, 10, page, size,
                URL + ENDPOINT);

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorCollection> findById(@PathVariable Integer id) {
        Director director = directorFindByIdUseCase.execute(id);
        DirectorCollection directorCollection = DirectorMapper.INSTANCE.toDirector(director);

        return ResponseEntity.ok(directorCollection);
    }
}