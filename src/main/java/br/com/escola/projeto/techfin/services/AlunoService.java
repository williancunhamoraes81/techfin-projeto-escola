package br.com.escola.projeto.techfin.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.escola.projeto.techfin.entities.Aluno;
import br.com.escola.projeto.techfin.respositories.AlunoRepository;
import br.com.escola.projeto.techfin.services.exceptions.DatabaseException;
import br.com.escola.projeto.techfin.services.exceptions.ResourceNotFoundException;

@Service
@Transactional()
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(Long id){
		Optional<Aluno> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Aluno insert(Aluno obj) {
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
	
	public Aluno update(Long id, Aluno obj) {
		try {
			Aluno entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {			
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Aluno entity, Aluno obj) {
		if(obj.getNome() != null) {
			entity.setNome(obj.getNome());
		}
		
		if(obj.getEmail() != null) {
			entity.setEmail(obj.getEmail());
		}

		if(obj.getMatricula() != null) {
			entity.setMatricula(obj.getMatricula());
		}
		
		if(obj.getCpf() != null) {
			entity.setCpf(obj.getCpf());
		}
		
		if(obj.getFormaIngresso() != null) {
			entity.setFormaIngresso(obj.getFormaIngresso());
		}
				
	}
		
}
