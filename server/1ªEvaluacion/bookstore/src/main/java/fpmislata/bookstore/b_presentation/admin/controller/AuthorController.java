package fpmislata.bookstore.b_presentation.admin.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.bookstore.b_presentation.admin.mapper.AuthorMapper;
import fpmislata.bookstore.b_presentation.admin.model.AuthorCollection;
import fpmislata.bookstore.b_presentation.admin.model.AuthorDetail;
import fpmislata.bookstore.b_presentation.common.Paginator;
import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorCreateUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorDeleteUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorFindAllUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorFindByIdUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.author.interfaces.AuthorUpdateUseCase;
import fpmislata.bookstore.c_domain._2service.model.Author;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorFindAllUseCase authorFindAllUseCase;
    private final AuthorFindByIdUseCase authorFindByIdUseCase;
    private final AuthorCreateUseCase authorCreateUseCase;
    private final AuthorUpdateUseCase authorUpdateUseCase;
    private final AuthorDeleteUseCase authorDeleteUseCase;

    @Value("${url}")
    private String url;

    @GetMapping("/api/authors")
    public ResponseEntity<Paginator<AuthorCollection>> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false) Integer size) {

        try {
            List<Author> authorList = authorFindAllUseCase.execute(page, size);
            List<AuthorCollection> authorCollectionList = AuthorMapper.INSTANCE.toAuthorCollectionList(authorList);
            Paginator<AuthorCollection> paginator = new Paginator<>(authorCollectionList, 10, page, size,
                    url + "/authors");

            return ResponseEntity.ok(paginator);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/api/authors/{id}")
    public ResponseEntity<AuthorDetail> findById(@PathVariable Integer id) {

        try {
            Author author = authorFindByIdUseCase.execute(id);
            AuthorDetail authorDetail = AuthorMapper.INSTANCE.toAuthorDetail(author);
            return ResponseEntity.ok(authorDetail);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/api/authors")
    public ResponseEntity<Integer> create(
            @RequestParam String name,
            @RequestParam String nationality,
            @RequestParam String biographyEs,
            @RequestParam String biographyEn,
            @RequestParam Integer birthYear,
            @RequestParam Integer deathYear) {

        try {
            Integer authorId = authorCreateUseCase.execute(name, nationality, biographyEs, biographyEn, birthYear,
                    deathYear);
            return ResponseEntity.ok(authorId);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/api/authors/{id}")
    public ResponseEntity<Boolean> update(
            @PathVariable Integer id,
            @RequestParam String name,
            @RequestParam String nationality,
            @RequestParam String biographyEs,
            @RequestParam String biographyEn,
            @RequestParam Integer birthYear,
            @RequestParam Integer deathYear) {

        try {
            Boolean status = authorUpdateUseCase.execute(id, name, nationality, biographyEs, biographyEn, birthYear,
                    deathYear);
            return ResponseEntity.ok(status);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/api/authors/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        try {
            Boolean status = authorDeleteUseCase.execute(id);
            return ResponseEntity.ok(status);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}