package com.example.persistencia.controller;

import com.example.persistencia.entity.Turma;
import com.example.persistencia.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService service;


    @GetMapping()
    public ResponseEntity get() {
        List<Turma> turmas = service.getTurmas();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Turma> turma = service.getTurmaById(id);
        if (!turma.isPresent()) {
            return new ResponseEntity("Turma não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(turma);
    }

    @GetMapping("{id}/alunos")
    public ResponseEntity getDisciplinas(@PathVariable("id") Long id) {
        Optional<Turma> turma = service.getTurmaById(id);
        if (!turma.isPresent()) {
            return new ResponseEntity("Turma não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(turma.get().getAlunos());
    }
}
