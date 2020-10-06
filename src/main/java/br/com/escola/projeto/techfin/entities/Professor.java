package br.com.escola.projeto.techfin.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_professor")
public class Professor extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private String titulacao;

	public Professor() {		
	}
		
	public Professor(Long id, String nome, String email, String cpf, String titulacao) {
		super(id, nome, email, cpf);
		this.titulacao = titulacao;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	
}
