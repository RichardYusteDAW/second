package fpmislata.bookstore.domain.service._2impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.service._1interfaceSer.AuthorService;
import fpmislata.bookstore.domain.service._3interfaceRep.AuthorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public Integer create(long id, String name, String nationality, String biography, int birthYear, int deathYear) {
        Author author = new Author(id, name, nationality, biography, birthYear, deathYear);
        return authorRepository.create(author);
    }

    @Override
    public Boolean update(long id, String name, String nationality, String biography, int birthYear, int deathYear) {
        return authorRepository.update(id, name, nationality, biography, birthYear, deathYear);
    }

    @Override
    public Boolean delete(Integer id) {
        return authorRepository.delete(id);
    }
}