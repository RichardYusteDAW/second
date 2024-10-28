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
        Integer authorId = authorRepository.create(author);
        if (authorId == null) {
            throw new ResourceNotFoundException("Author could not be created");
        }
        return authorId;
    }

    @Override
    public Boolean update(Integer id, String name, String nationality, String biographyEn, String biographyEs,
            Integer birthYear, Integer deathYear) {

        Author author = new Author(id, name, nationality, biographyEn, biographyEs, birthYear, deathYear);

        Boolean status = authorRepository.update(author);
        if (!status) {
            throw new ResourceNotFoundException("Author could not be updated");
        }
        return status;
    }

    @Override
    public Boolean delete(Integer id) {

        Boolean status = authorRepository.delete(id);
        if (!status) {
            throw new ResourceNotFoundException("Author could not be deleted");
        }
        return status;
    }
}