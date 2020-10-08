package br.com.escola.projeto.techfin.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.escola.projeto.techfin.entities.Aluno;
import br.com.escola.projeto.techfin.entities.Turma;
import br.com.escola.projeto.techfin.respositories.AlunoRepository;
import br.com.escola.projeto.techfin.respositories.TurmaRepository;
import br.com.escola.projeto.techfin.services.exceptions.DatabaseException;
import br.com.escola.projeto.techfin.services.exceptions.ResourceNotFoundException;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Turma> findAll(){
		return repository.findAll();
	}
	
	public Turma findById(Long id){
		Optional<Turma> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Turma insert(Turma obj) {		
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {			
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Turma update(Long id, Turma obj) {
		try {
			Turma entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {			
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Turma entity, Turma obj) {
		
		if(obj.getDescricao() != null) {
			entity.setDescricao(obj.getDescricao());
		}
		
		if(obj.getAnoLetivo() != null) {
			entity.setAnoLetivo(obj.getAnoLetivo());
		}

		if(obj.getPeriodoLetivo() != null) {
			entity.setPeriodoLetivo(obj.getPeriodoLetivo());
		}
		
		if(obj.getNumeroVagas() > 0) {
			entity.setNumeroVagas(obj.getNumeroVagas());
		}
		
		if(obj.getDisciplina() != null) {
			entity.setDisciplina(obj.getDisciplina());
		}
		
		if(!obj.getAlunos().isEmpty()) {
			List<Aluno> alunosNovos = new ArrayList();
			for(Aluno aluno : obj.getAlunos()) {
				alunosNovos.add(aluno);
			}		
			entity.setAlunos(alunosNovos);
		}
						
	}
		
}
