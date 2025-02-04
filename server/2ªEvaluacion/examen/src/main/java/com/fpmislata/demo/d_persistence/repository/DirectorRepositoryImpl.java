package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Director;
import com.fpmislata.demo.c_domain.repository.DirectorRepository;
import com.fpmislata.demo.d_persistence.jpa.interfaces.DirectorJpa;
import com.fpmislata.demo.d_persistence.jpa.mapper.DirectorMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DirectorRepositoryImpl implements DirectorRepository {

    private final DirectorJpa directorJpa;

    @Override
    public List<Director> findAll() {
        return DirectorMapper.INSTANCE.toDirectorList(directorJpa.findAll());
    }

    @Override
    public Optional<Director> findById(Integer id) {
        return directorJpa
                .findById(id)
                .map(d -> DirectorMapper.INSTANCE.toDirector(d));
    }
}