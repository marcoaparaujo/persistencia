package com.example.persistencia.controller;

import com.example.persistencia.entity.Aluno;
import com.example.persistencia.entity.Endereco;
import com.example.persistencia.entity.Turma;
import com.example.persistencia.service.AlunoService;
import com.example.persistencia.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Aluno> alunos = service.getAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Aluno> aluno = service.getAlunoById(id);
        if (!aluno.isPresent()) {
            return new ResponseEntity("Aluno não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(aluno);
    }


}
