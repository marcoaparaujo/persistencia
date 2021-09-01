package com.example.persistencia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends Pessoa {

    private Integer matricula;

    @ManyToOne
    private Curso curso;

}
