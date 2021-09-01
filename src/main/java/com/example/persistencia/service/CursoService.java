package com.example.persistencia.service;

import com.example.persistencia.entity.Curso;
import com.example.persistencia.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> getCursos() {
        return repository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Curso salvar(Curso curso) {
        return repository.save(curso);
    }
}
