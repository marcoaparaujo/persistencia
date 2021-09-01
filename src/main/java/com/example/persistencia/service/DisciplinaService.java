package com.example.persistencia.service;

import com.example.persistencia.entity.Aluno;
import com.example.persistencia.entity.Curso;
import com.example.persistencia.entity.Disciplina;
import com.example.persistencia.repository.AlunoRepository;
import com.example.persistencia.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public List<Disciplina> getDisciplinas() {
        return repository.findAll();
    }

    public Optional<Disciplina> getDisciplinaById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Disciplina salvar(Disciplina disciplina) {
        return repository.save(disciplina);
    }
}
