package br.com.escola.projeto.techfin.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "tb_turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Favor preencher a descrição.")
	@Length(min = 5, max = 80, message = "A descrição deve conter entre 5 e 80 caracteres.")
	private String descricao;
		
	@NotNull(message = "Favor inserir ano letivo.")
	@Range(min = 1950, max = 2300, message = "Favor inserir ano letivo válido.")
	private Integer anoLetivo;
	
	@NotNull(message = "Favor inserir período letivo.")
	@Range(min = 1950, max = 2300, message = "Favor inserir período letivo válido.")
	private Integer periodoLetivo;
	
	@Range(min = 1, message = "Favor preencher o número de vagas.")
	private int numeroVagas;
	
	@NotNull(message = "Favor selecionar a disciplina.")
	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;
		
	@OneToMany
	@JoinTable(name = "tb_turma_aluno", joinColumns = {
			@JoinColumn(name = "turma_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "aluno_id", referencedColumnName = "id") })
	private List<Aluno> alunos = new ArrayList();

	public Turma() {

	}

	public Turma(Long id, String descricao, Integer anoLetivo, Integer periodoLetivo, int numeroVagas,
			Disciplina disciplina) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.anoLetivo = anoLetivo;
		this.periodoLetivo = periodoLetivo;
		this.numeroVagas = numeroVagas;
		this.disciplina = disciplina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(Integer anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public Integer getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(Integer periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
