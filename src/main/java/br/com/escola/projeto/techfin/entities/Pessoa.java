package br.com.escola.projeto.techfin.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Favor preencher o nome.")
	@Length(min = 5, max = 80, message = "O nome deve conter entre 5 e 80 caracteres.")
	private String nome;
		
	@NotBlank(message="Favor informar e-mail.")
	@Email(regexp =".+@.+\\..+", message = "E-mail inválido")	
	private String email;
	
	@NotBlank(message="Favor informar cpf.")
	@CPF(message = "CPF inválido.")
	private String cpf;
		
	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	private List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	
	public Pessoa() {
		
	}

	public Pessoa(Long id, String nome, String email, String cpf) {		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
			
	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
	
	
}

