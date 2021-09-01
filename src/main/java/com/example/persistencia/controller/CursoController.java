package com.example.persistencia.controller;

import com.example.persistencia.entity.Curso;
import com.example.persistencia.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Curso> cursos = service.getCursos();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Curso> curso = service.getCursoById(id);
        if (!curso.isPresent()) {
            return new ResponseEntity("Curso não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(curso);
    }

    @PostMapping()
    public ResponseEntity post(Curso curso) {
        try {
            curso = service.salvar(curso);
            return new ResponseEntity(curso, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
