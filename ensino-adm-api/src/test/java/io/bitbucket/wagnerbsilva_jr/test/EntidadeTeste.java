package io.bitbucket.wagnerbsilva_jr.test;

import io.bitbucket.wagnerbsilva_jr.model.entity.Professor;
import io.bitbucket.wagnerbsilva_jr.model.repository.ProfessorRepository;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntidadeTeste {

    @Test
    public void ProfessorTeste() {
        Professor professor = new Professor();
        professor.setNome("nome");
        professor.setCpf("43236560177");
        professor.setNascimento(LocalDate.parse("1978-09-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        professor.setSexo("M");
        professor.setEmail("wagnerjf@gmail.com");

        assertEquals("nome", professor.getNome());
        assertTrue(professor.toString().contains("Professor{"));

    }

}