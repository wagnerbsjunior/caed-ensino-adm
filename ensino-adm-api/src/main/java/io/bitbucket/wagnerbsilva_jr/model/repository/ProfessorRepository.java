package io.bitbucket.wagnerbsilva_jr.model.repository;

import io.bitbucket.wagnerbsilva_jr.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    boolean existsByCpf( String cpf );

    Optional<Professor> findByCpf( String cpf );


}
