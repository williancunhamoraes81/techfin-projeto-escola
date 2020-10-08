package br.com.escola.projeto.techfin.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.escola.projeto.techfin.entities.Aluno;
import br.com.escola.projeto.techfin.entities.Disciplina;
import br.com.escola.projeto.techfin.entities.Turma;
import br.com.escola.projeto.techfin.services.TurmaService;

@RestController
@RequestMapping(value="/turmas")
public class TurmaResource {

	@Autowired
	private TurmaService service;
	
	@GetMapping()
	public ResponseEntity<List<Turma>> findAll(){		
		List<Turma> list = service.findAll();		
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Long id){		
		Turma turma = service.findById(id);
		return ResponseEntity.ok().body(turma);		
	}
	
	@PostMapping
	public ResponseEntity<Turma> insert(@Valid @RequestBody Turma obj){		
		service.insert(obj);
		URI locationURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return  ResponseEntity.created(locationURI).body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@PutMapping(value="/{id}")
	public ResponseEntity<Turma> update(@PathVariable Long id, @Valid @RequestBody Turma obj){
		obj = service.update(id, obj);
		return  ResponseEntity.ok().body(obj);
	}
	
}
