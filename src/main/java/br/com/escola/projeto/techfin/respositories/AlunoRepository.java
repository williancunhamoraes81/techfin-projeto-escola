package br.com.escola.projeto.techfin.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.projeto.techfin.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
