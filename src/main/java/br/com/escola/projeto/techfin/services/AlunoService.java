package br.com.escola.projeto.techfin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.escola.projeto.techfin.entities.Aluno;
import br.com.escola.projeto.techfin.respositories.AlunoRepository;
import br.com.escola.projeto.techfin.services.exceptions.DatabaseException;
import br.com.escola.projeto.techfin.services.exceptions.ResourceNotFoundException;

@Service
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
		
}
