package br.com.escola.projeto.techfin.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.escola.projeto.techfin.entities.Disciplina;
import br.com.escola.projeto.techfin.entities.Professor;
import br.com.escola.projeto.techfin.respositories.DisciplinaRepository;
import br.com.escola.projeto.techfin.respositories.ProfessorRepository;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner{

	@Autowired
	DisciplinaRepository repositoryDisciplina;
	
	@Autowired
	ProfessorRepository repositoryProfessor;
	
	@Override
	public void run(String... args) throws Exception {
		
		Professor pessoa1 = new Professor(null, "Willian Cunha de Moraes", "wmoraes@gmail.com", "29509641847", "Dr");
		Professor pessoa2 = new Professor(null, "Barbara Oliverida de Moraes", "babiz@gmail.com", "29509641847", "PhD");
		
		repositoryProfessor.saveAll(Arrays.asList(pessoa1,pessoa2));
				
		Disciplina dsp1 = new Disciplina(null, "Matemática", "MAT", 180, pessoa1);
		Disciplina dsp2 = new Disciplina(null, "Geografia", "GEO", 140, pessoa1);
		Disciplina dsp3 = new Disciplina(null, "História", "HIS", 120, pessoa1);
		Disciplina dsp4 = new Disciplina(null, "Química", "QUI", 80, pessoa2);
		Disciplina dsp5 = new Disciplina(null, "Artes", "ART", 280, pessoa1);
		
		repositoryDisciplina.saveAll(Arrays.asList(dsp1, dsp2, dsp3, dsp4, dsp5));
		
	}

}
