package com.example.persistencia.service;

import com.example.persistencia.entity.Turma;
import com.example.persistencia.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public List<Turma> getTurmas() {
        return repository.findAll();
    }

    public Optional<Turma> getTurmaById(Long id) {
        return repository.findById(id);
    }
}
