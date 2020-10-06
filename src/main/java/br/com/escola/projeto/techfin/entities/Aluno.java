package br.com.escola.projeto.techfin.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String matricula;
	private String formaIngresso;
	
	public Aluno() {
				
	}
		
	public Aluno(Long id, String nome, String email, String cpf, String matricula, String formaIngresso) {
		super(id, nome, email, cpf);
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFormaIngresso() {
		return formaIngresso;
	}

	public void setFormaIngresso(String formaIngresso) {
		this.formaIngresso = formaIngresso;
	}
	
	
}
