package com.example.persistencia.controller;

import com.example.persistencia.entity.Aluno;
import com.example.persistencia.entity.Curso;
import com.example.persistencia.entity.Disciplina;
import com.example.persistencia.service.AlunoService;
import com.example.persistencia.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Disciplina> disciplinas = service.getDisciplinas();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Disciplina> disciplina = service.getDisciplinaById(id);
        if (!disciplina.isPresent()) {
            return new ResponseEntity("Disciplina não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(disciplina);
    }

    @PostMapping()
    public ResponseEntity post(Disciplina disciplina) {
        try {
            disciplina = service.salvar(disciplina);
            return new ResponseEntity(disciplina, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
