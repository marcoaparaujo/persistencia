package com.example.persistencia;

import com.example.persistencia.entity.Aluno;
import com.example.persistencia.service.AlunoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class PersistenciaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersistenciaApplication.class, args);
    }

}
