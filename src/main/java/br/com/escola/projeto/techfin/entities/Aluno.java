package br.com.escola.projeto.techfin.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotBlank(message="Favor informar a matricula.")
	@Length(min = 4, max = 4, message = "O campo matrícula deve conter 4 caracteres.")
	private String matricula;
	
	@NotNull
	@NotBlank(message="Favor informar a forma de ingresso.")
	private String formaIngresso;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_turma_aluno", joinColumns = {
			@JoinColumn(name = "aluno_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "turma_id", referencedColumnName = "id") })
	private Turma turma;

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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
