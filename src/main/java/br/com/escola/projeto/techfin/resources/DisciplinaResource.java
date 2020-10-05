package br.com.escola.projeto.techfin.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escola.projeto.techfin.entities.Disciplina;
import br.com.escola.projeto.techfin.services.DisciplinaService;

@RestController
@RequestMapping(value="/disciplinas")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService service;
	
	@GetMapping()
	public ResponseEntity<List<Disciplina>> findAll(){		
		List<Disciplina> list = service.findAll();		
		return ResponseEntity.ok().body(list);		
	}
	
}
