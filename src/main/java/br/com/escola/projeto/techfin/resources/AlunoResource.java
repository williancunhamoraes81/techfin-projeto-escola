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
import br.com.escola.projeto.techfin.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService service;
	
	@GetMapping()
	public ResponseEntity<List<Aluno>> findAll(){		
		List<Aluno> list = service.findAll();		
		return ResponseEntity.ok().body(list);		
	}
			
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id){		
		Aluno aluno = service.findById(id);
		return ResponseEntity.ok().body(aluno);		
	}
	
	@PostMapping
	public ResponseEntity<Aluno> insert(@Valid @RequestBody Aluno obj){		
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
	public ResponseEntity<Aluno> update(@PathVariable Long id, @Valid @RequestBody Aluno obj){
		obj = service.update(id, obj);
		return  ResponseEntity.ok().body(obj);
	}
	
}
