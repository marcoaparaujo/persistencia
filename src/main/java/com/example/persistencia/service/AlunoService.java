package com.example.persistencia.service;

import com.example.persistencia.entity.Aluno;
import com.example.persistencia.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> getAlunos() {
        return repository.findAll();
    }

    public Optional<Aluno> getAlunoById(Long id) {
        return repository.findById(id);
    }

}
