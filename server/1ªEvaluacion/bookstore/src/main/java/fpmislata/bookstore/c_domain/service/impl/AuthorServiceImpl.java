package fpmislata.bookstore.c_domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.a_common.exception.ResourceNotFoundException;
import fpmislata.bookstore.c_domain.model.Author;
import fpmislata.bookstore.c_domain.repository.AuthorRepository;
import fpmislata.bookstore.c_domain.service.interfaces.AuthorService;
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
    public Author findByBookISBN(Integer ISBN) {
        return authorRepository.findByBookISBN(ISBN)
                .orElseThrow(() -> new ResourceNotFoundException("Author does not exist"));
    }

    @Override
    public Integer create(String name, String nationality, String biographyEs, String biographyEn, Integer birthYear,
            Integer deathYear) {
        Author author = new Author(name, nationality, biographyEs, biographyEn, birthYear, deathYear);
        return authorRepository.create(author);
    }

    @Override
    public Boolean update(Integer id, String name, String nationality, String biographyEn, String biographyEs,
            Integer birthYear, Integer deathYear) {
        return authorRepository.update(id, name, nationality, biographyEn, biographyEs, birthYear, deathYear);
    }

    @Override
    public Boolean delete(Integer id) {
        return authorRepository.delete(id);
    }
}