package io.bitbucket.wagnerbsilva_jr.test.model.repository;

import io.bitbucket.wagnerbsilva_jr.model.entity.Professor;
import io.bitbucket.wagnerbsilva_jr.model.repository.ProfessorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class ProfessorRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProfessorRepository repository;

    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um CPF já informado")
    public void returnTrueWhenCpfExists(){
        //cenário
        String cpf = "43236560177";
        Professor professor = createNewProfessor(cpf);
        entityManager.persist(professor);

        //execução
        boolean exists = repository.existsByCpf(cpf);

        //verificação
        assertThat(exists).isTrue();
    }

    public static Professor createNewProfessor(String cpf) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return Professor.builder()
                .nome("Fulano")
                .cpf(cpf)
                .nascimento(LocalDate.parse("1978-09-12"))
                .sexo("M")
                .email("wagnerjf@gmail.com")
                .build();

    }

    @Test
    @DisplayName("Deve retornar false quando não existir um professor na base com o CPF informado")
    public void returnFalseWhenCpfExist(){
        //cenário
        String cpf = "43236560177";

        //execução
        boolean exists = repository.existsByCpf(cpf);

        //verificação
        assertThat(exists).isFalse();

    }

    @Test
    @DisplayName("Deve retornar um professor por id")
    public void findByIdTest(){
        //cenário
        Professor professor = createNewProfessor("43236560177");
        entityManager.persist(professor);

        //execução
        Optional<Professor> foundProfessor = repository.findById(professor.getId());


        //verificação
        assertThat(foundProfessor.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Deve retornar um professor por id")
    public void saveProfessorTest(){
        //cenário
        Professor professor = createNewProfessor("43236560177");

        //execução
        Professor savedProfessor = repository.save(professor);

        //verificação
        assertThat(savedProfessor.getId()).isNotNull();
    }

    @Test
    @DisplayName("Deve deletar um professor")
    public void deleteProfessorTest(){
        //cenário
        Professor professor = createNewProfessor("43236560177");
        entityManager.persist(professor);
        Professor foundProfessor = entityManager.find( Professor.class, professor.getId() );

        //execução
        repository.delete(foundProfessor);

        Professor deletedProfessor = entityManager.find( Professor.class, professor.getId() );

        //verificação
        assertThat(deletedProfessor).isNull();
    }

    @Test
    @DisplayName("Deve calcular e salvar a idade do professor")
    public void returnTrueWhenCalcIdade(){
        //cenário
        Professor professor = createNewProfessor("43236560177");

        //execução
        Professor savedProfessor = repository.save(professor);

        //verificação
        assertThat(savedProfessor.getIdade()).isNotNull();
    }

    @Test
    @DisplayName("Deve salvar a data de criação do cadastro do professor")
    public void returnTrueWhenDataCriacaoGerada(){
        //cenário
        Professor professor = createNewProfessor("43236560177");

        //execução
        Professor savedProfessor = repository.save(professor);

        //verificação
        assertThat(savedProfessor.getDataCriacao()).isNotNull();
    }

    @Test
    @DisplayName("Deve salvar a data de alteração do cadastro do professor")
    public void returnTrueWhenDataAlteracaoGerada(){
        //cenário
        Professor professor = createNewProfessor("43236560177");
        entityManager.persist(professor);
        Professor foundProfessor = entityManager.find( Professor.class, professor.getId() );

        //execução
        foundProfessor.setNome("Fulano de tal");
        foundProfessor.preUpdate();
        Professor savedProfessor = repository.save(foundProfessor);

        //Professor updatedProfessor = entityManager.find( Professor.class, professor.getId() );

        //verificação
        assertThat(savedProfessor.getDataAlteracao()).isNotNull();
    }

}
