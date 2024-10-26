package fpmislata.bookstore.b_presentation.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.bookstore.b_presentation.admin.mapper.AuthorMapper;
import fpmislata.bookstore.b_presentation.admin.model.AuthorCollection;
import fpmislata.bookstore.b_presentation.common.Paginator;
import fpmislata.bookstore.c_domain.model.Author;
import fpmislata.bookstore.c_domain.usecase.author.interfaces.AuthorFindAllUseCase;
import fpmislata.bookstore.c_domain.usecase.author.interfaces.AuthorFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorFindAllUseCase authorFindAllUseCase;
    private final AuthorFindByIdUseCase authorFindByIdUseCase;

    @Value("${baseUrl}")
    private String baseUrl;

    @GetMapping("/api/authors")
    public ResponseEntity<Paginator<AuthorCollection>> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false) Integer size) {

        List<Author> authorList = authorFindAllUseCase.execute(page, size);
        List<AuthorCollection> authorCollectionList = AuthorMapper.INSTANCE.toAuthorCollectionList(authorList);
        Paginator<AuthorCollection> paginator = new Paginator<>(authorCollectionList, 10, page, size,
                baseUrl + "/authors");

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/api/authors/{id}")
    public ResponseEntity<Author> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(authorFindByIdUseCase.execute(id));
    }

}