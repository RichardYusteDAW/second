package fpmislata.bookstore.c_domain._2service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.a_common.exception.ResourceNotFoundException;
import fpmislata.bookstore.c_domain._2service.interfaces.AuthorService;
import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.d_persistence.repository.interfaces.AuthorRepository;
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
    public List<Author> findAllById(List<Author> authorList) {
        // Convert List<Author> to ArrayList<Integer>
        List<Long> ids = authorList.stream().map(author -> author.getId()).toList();

        // Find all authors by id
        List<Author> foundAuthors = authorRepository.findAllById(ids);

        // Check if all authors were found
        if (foundAuthors.size() != authorList.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }

        return foundAuthors;
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author does not exist"));
    }

    @Override
    public Author findByBookISBN(Integer ISBN) {
        return authorRepository.findByBookISBN(ISBN)
                .orElseThrow(() -> new ResourceNotFoundException("Author does not exist"));
    }

    @Override
    public Long create(String name, String nationality, String biographyEs, String biographyEn, Integer birthYear,
            Integer deathYear) {

        Author author = new Author(name, nationality, biographyEs, biographyEn, birthYear, deathYear);
        Long authorId = authorRepository.create(author);
        if (authorId == null) {
            throw new ResourceNotFoundException("Author could not be created");
        }
        return authorId;
    }

    @Override
    public Boolean update(Long id, String name, String nationality, String biographyEn, String biographyEs,
            Integer birthYear, Integer deathYear) {

        Author author = new Author(id, name, nationality, biographyEn, biographyEs, birthYear, deathYear);

        Boolean status = authorRepository.update(author);
        if (!status) {
            throw new ResourceNotFoundException("Author could not be updated");
        }
        return status;
    }

    @Override
    public Boolean delete(Long id) {

        Boolean status = authorRepository.delete(id);
        if (!status) {
            throw new ResourceNotFoundException("Author could not be deleted");
        }
        return status;
    }
}