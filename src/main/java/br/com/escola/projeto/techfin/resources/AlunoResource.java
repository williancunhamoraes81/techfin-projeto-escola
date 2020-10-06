package br.com.escola.projeto.techfin.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			
	
}
