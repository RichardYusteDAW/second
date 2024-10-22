package fpmislata.bookstore._3domain.admin._2service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore._1common.exception.ResourceNotFoundException;
import fpmislata.bookstore._3domain.admin._2service._1interfaceSer.AuthorService;
import fpmislata.bookstore._3domain.admin._3repInterface.AuthorRepository;
import fpmislata.bookstore._3domain.model.AuthorCommand;
import fpmislata.bookstore._3domain.model.AuthorQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorQuery> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorQuery findById(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author does not exist"));
    }

    @Override
    public Integer create(String name, String nationality, String biography_en, String biography_es, Integer birthYear,
            Integer deathYear) {
        AuthorCommand author = new AuthorCommand(name, nationality, biography_en, biography_es, birthYear, deathYear);
        return authorRepository.create(author);
    }

    @Override
    public Boolean update(long id, String name, String nationality, String biography_en, String biography_es,
            Integer birthYear, Integer deathYear) {
        return authorRepository.update(id, name, nationality, biography_en, biography_es, birthYear, deathYear);
    }

    @Override
    public Boolean delete(Integer id) {
        return authorRepository.delete(id);
    }
}