package br.com.escola.projeto.techfin.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.escola.projeto.techfin.entities.Disciplina;
import br.com.escola.projeto.techfin.entities.Pessoa;
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
		
		Professor prof1 = new Professor(null, "Antônio Augusto", "antonio.augusto@gmail.com", "000000000", "Senior");
		Professor prof2 = new Professor(null, "Maria Clara", "maria.clara@gmail.com", "000000000", "Doctor");
		Professor prof3 = new Professor(null, "João Lucas", "joao.lucas@gmail.com", "000000000", "Jr");		
		Professor prof4 = new Professor(null, "Ana Carolina", "ana.carolina@gmail.com", "0000000000", "PhD");
		
		repositoryProfessor.saveAll(Arrays.asList(prof1,prof2,prof3,prof4));
				
		Disciplina dsp1 = new Disciplina(null, "Matemática", "MAT", 180, prof1);
		Disciplina dsp2 = new Disciplina(null, "Geografia", "GEO", 140, prof2);
		Disciplina dsp3 = new Disciplina(null, "História", "HIS", 120, prof1);
		Disciplina dsp4 = new Disciplina(null, "Química", "QUI", 80, prof1);
		Disciplina dsp5 = new Disciplina(null, "Artes", "ART", 280, prof3);
		Disciplina dsp6 = new Disciplina(null, "Ed. Física", "ART", 280, prof4);
		
		repositoryDisciplina.saveAll(Arrays.asList(dsp1, dsp2, dsp3, dsp4, dsp5, dsp6));
		
	}

}
