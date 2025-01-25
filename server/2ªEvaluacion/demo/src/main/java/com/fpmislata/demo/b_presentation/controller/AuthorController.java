package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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
    public List<AuthorSimple> findAll() {
        List<Author> authorList = authorFindAllUseCase.execute();
        return AuthorMapper.INSTANCE.toAuthorSimpleList(authorList);
    }

    @GetMapping("/{id}")
    public AuthorComplete findById(@PathVariable String id) {
        Author author = authorFindByIdUseCase.execute(Integer.parseInt(id));
        return AuthorMapper.INSTANCE.toAuthorComplete(author);
    }

    @PostMapping()
    public void create(@Valid @RequestBody AuthorComplete authorComplete) {
        authorCreateUseCase.execute(AuthorMapper.INSTANCE.toAuthor(authorComplete));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @Valid @RequestBody AuthorComplete authorComplete) {
        Author author = AuthorMapper.INSTANCE.toAuthor(authorComplete);
        author.setId(Integer.parseInt(id));
        authorUpdateUseCase.execute(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        authorDeleteUseCase.execute(Integer.parseInt(id));
    }
}