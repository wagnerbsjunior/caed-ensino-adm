package io.bitbucket.wagnerbsilva_jr.model.repository;

import io.bitbucket.wagnerbsilva_jr.model.entity.Professor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProfessorRepositoryTeste {

    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    public void testProfessor() {
        this.insertProfessor();
        this.updateProfessor();
    }

    @Test
    public Professor insertProfessor() {
        Professor professor = new Professor();
        professor.setNome("nome");
        professor.setCpf("43236560177");
        professor.setNascimento(LocalDate.parse("1978-09-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        professor.setSexo("M");
        professor.setEmail("wagnerjf@gmail.com");

        professorRepository.save(professor);

        Integer countProfessor = professorRepository.findAll().size();
        assertEquals(1, countProfessor);

        assertNotNull(professor.getIdade());
        assertNotNull(professor.getDataCriacao());
        assertNull(professor.getDataAlteracao());

        return professor;
    }

    @Test
    public void updateProfessor() {
        Professor professorAtualizado = this.insertProfessor();

        professorAtualizado.setNome("wagner barros");

        try {
            professorRepository
                    .findById(1)
                    .map(professor -> {
                        professor.setNome(professorAtualizado.getNome());
                        professor.setCpf(professorAtualizado.getCpf());
                        professor.setEmail(professorAtualizado.getEmail());
                        professor.setNascimento(professorAtualizado.getNascimento());
                        professor.setSexo(professorAtualizado.getSexo());

                        return professorRepository.save(professor);
                    });
        } catch (Exception e) {}

        Integer countProfessor = professorRepository.findAll().size();
        assertEquals(2, countProfessor);

        assertNotNull(professorAtualizado.getDataAlteracao());
    }

}
