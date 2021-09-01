package com.example.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Pessoa {

    private Integer matricula;

    @ManyToOne
    @JsonManagedReference
    private Curso curso;

    @JsonBackReference
    @ManyToMany(mappedBy = "alunos")
    private List<Turma> turmas;

}
