package io.bitbucket.wagnerbsilva_jr.model.repository;

import io.bitbucket.wagnerbsilva_jr.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
