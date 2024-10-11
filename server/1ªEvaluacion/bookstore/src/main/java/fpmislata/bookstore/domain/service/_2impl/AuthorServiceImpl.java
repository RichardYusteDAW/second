package fpmislata.bookstore.domain.service._2impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.common.exception.ResourceNotFoundException;
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
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author does not exist"));
    }

    @Override
    public Integer create(String name, String nationality, String biography, Integer birthYear, Integer deathYear) {
        Author author = new Author(name, nationality, biography, birthYear, deathYear);
        return authorRepository.create(author);
    }

    @Override
    public Boolean update(long id, String name, String nationality, String biography, Integer birthYear,
            Integer deathYear) {
        return authorRepository.update(id, name, nationality, biography, birthYear, deathYear);
    }

    @Override
    public Boolean delete(Integer id) {
        return authorRepository.delete(id);
    }
}