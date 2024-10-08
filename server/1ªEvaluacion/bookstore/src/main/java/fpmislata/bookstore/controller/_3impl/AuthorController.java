package fpmislata.bookstore.controller._3impl;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.bookstore.controller._1model.AuthorCollection;
import fpmislata.bookstore.controller._1model.AuthorDetail;
import fpmislata.bookstore.controller._2mapper.AuthorMapper;
import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.service._1interfaceSer.AuthorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorCollection> findAll() {
        return authorService.findAll()
                .stream()
                .map(author -> AuthorMapper.INSTANCE.toAuthorCollection(author))
                .toList();
    }

    @GetMapping("/{id}")
    public AuthorDetail findById(@PathVariable Integer id) {
        Author author = authorService.findById(id);
        if (author == null) {
            System.out.println("El autor no existe");
        }
        return AuthorMapper.INSTANCE.toAuthorDetail(author);
    }

    @PostMapping()
    public Integer create(
            @RequestParam String name,
            @RequestParam String nationality,
            @RequestParam String biography,
            @RequestParam Integer birthYear,
            @RequestParam Integer deathYear) {

        return authorService.create(name, nationality, biography, birthYear, deathYear);
    }

    @PutMapping("/{id}")
    public Boolean update(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String nationality,
            @RequestParam String biography,
            @RequestParam Integer birthYear,
            @RequestParam Integer deathYear) {

        return authorService.update(id, name, nationality, biography, birthYear, deathYear);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return authorService.delete(id);
    }
}