package br.com.escola.projeto.techfin.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.projeto.techfin.entities.Pessoa;

public interface ProfessorRepository extends JpaRepository<Pessoa, Long>{

}
