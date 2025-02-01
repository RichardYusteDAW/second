package com.fpmislata.demo.b_presentation.controller;

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

import com.fpmislata.demo.b_presentation.mapper.AuthorMapper;
import com.fpmislata.demo.b_presentation.model.AuthorWebModel;
import com.fpmislata.demo.b_presentation.model.Paginator;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorFindAllWithCountUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(AuthorController.ENDPOINT)
public class AuthorController {

    private final AuthorFindAllUseCase authorFindAllUseCase;
    private final AuthorFindAllWithCountUseCase authorFindAllWithCountUseCase;
    private final AuthorFindByIdUseCase authorFindByIdUseCase;
    private final AuthorCreateUseCase authorCreateUseCase;
    private final AuthorUpdateUseCase authorUpdateUseCase;
    private final AuthorDeleteUseCase authorDeleteUseCase;

    @Value("${URL}")
    private String URL;
    public static final String ENDPOINT = "/authors";

    @GetMapping()
    public ResponseEntity<List<AuthorWebModel>> findAll() {
        List<Author> authorList = authorFindAllUseCase.execute();
        List<AuthorWebModel> authorWebModelList = AuthorMapper.INSTANCE.toAuthorWebModelList(authorList);

        return ResponseEntity.ok(authorWebModelList);
    }

    @GetMapping("/paginator")
    public ResponseEntity<Paginator<AuthorWebModel>> findAllAllWithCount(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        ListWithCount<Author> authorList = authorFindAllWithCountUseCase.execute(page, size);

        List<AuthorWebModel> authorWebModelList = AuthorMapper.INSTANCE.toAuthorWebModelList(authorList.getList());
        Integer total = authorList.getCount();
        String baseUrl = URL + ENDPOINT;

        Paginator<AuthorWebModel> paginator = new Paginator<>(authorWebModelList, total, page, size, baseUrl);

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Integer id) {
        Author author = authorFindByIdUseCase.execute(id);

        return ResponseEntity.ok(author);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody Author author) {
        authorCreateUseCase.execute(author);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Author author) {
        author.setId(id);
        authorUpdateUseCase.execute(author);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        authorDeleteUseCase.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}