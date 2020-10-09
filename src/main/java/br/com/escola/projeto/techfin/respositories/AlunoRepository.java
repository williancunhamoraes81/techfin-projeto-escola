package br.com.escola.projeto.techfin.respositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.escola.projeto.techfin.entities.Aluno;

@Repository
@Transactional()
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
