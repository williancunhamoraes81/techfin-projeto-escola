package br.com.escola.projeto.techfin.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.escola.projeto.techfin.entities.Disciplina;
import br.com.escola.projeto.techfin.respositories.DisciplinaRepository;
import br.com.escola.projeto.techfin.services.exceptions.DatabaseException;
import br.com.escola.projeto.techfin.services.exceptions.ResourceNotFoundException;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository repository;
	
	public List<Disciplina> findAll(){
		return repository.findAll();
	}
	
	public Disciplina findById(Long id){
		Optional<Disciplina> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Disciplina insert(Disciplina obj) {
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
		
}
