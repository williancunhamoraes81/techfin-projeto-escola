package br.com.escola.projeto.techfin.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.projeto.techfin.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
