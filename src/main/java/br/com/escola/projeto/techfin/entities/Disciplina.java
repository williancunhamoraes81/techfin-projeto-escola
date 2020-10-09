package br.com.escola.projeto.techfin.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long value;
	
	private String nome;
	private String label;
	private String sigla;
	private int cargaHoraria;	
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Pessoa professor;
		
	@OneToMany(mappedBy = "disciplina")
	private List<Turma> turma = new ArrayList();
	
	public Disciplina() {
		
	}

	public Disciplina(Long id, String nome, String sigla, int cargaHoraria, Pessoa professor) {
		super();
		this.id = id;
		this.value = id;
		this.nome = nome;
		this.label = nome;
		this.sigla = sigla;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
	}

	public Long getValue() {
		return id;
	}
	
	public void setValue(Long id) {
		this.value = id;
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
	
	public String getLabel() {
		return getNome();
	}

	public void setLabel(String nome) {
		this.label = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
		
	public Pessoa getProfessor() {
		return professor;
	}

	public void setProfessor(Pessoa professor) {
		this.professor = professor;
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
		Disciplina other = (Disciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
