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
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.b_presentation.mapper.AuthorMapper;
import com.fpmislata.demo.b_presentation.model.AuthorComplete;
import com.fpmislata.demo.b_presentation.model.AuthorSimple;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(AuthorController.ENDPOINT)
public class AuthorController {

    private final AuthorFindAllUseCase authorFindAllUseCase;
    private final AuthorFindByIdUseCase authorFindByIdUseCase;
    private final AuthorCreateUseCase authorCreateUseCase;
    private final AuthorUpdateUseCase authorUpdateUseCase;
    private final AuthorDeleteUseCase authorDeleteUseCase;

    @Value("${url}")
    private String url;
    public static final String ENDPOINT = "/authors";

    @GetMapping()
    public ResponseEntity<List<AuthorSimple>> findAll() {
        List<Author> authorList = authorFindAllUseCase.execute();
        List<AuthorSimple> authorSimpleList = AuthorMapper.INSTANCE.toAuthorSimpleList(authorList);

        return ResponseEntity.ok(authorSimpleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorComplete> findById(@PathVariable Integer id) {
        Author author = authorFindByIdUseCase.execute(id);
        AuthorComplete authorComplete = AuthorMapper.INSTANCE.toAuthorComplete(author);

        return ResponseEntity.ok(authorComplete);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody AuthorComplete authorComplete) {
        authorCreateUseCase.execute(AuthorMapper.INSTANCE.toAuthor(authorComplete));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody AuthorComplete authorComplete) {
        Author author = AuthorMapper.INSTANCE.toAuthor(authorComplete);
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