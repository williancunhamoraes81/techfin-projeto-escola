package br.com.escola.projeto.techfin.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.escola.projeto.techfin.entities.Disciplina;
import br.com.escola.projeto.techfin.respositories.DisciplinaRepository;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner{

	@Autowired
	DisciplinaRepository repositoryDsp;
	
	@Override
	public void run(String... args) throws Exception {
		
		Disciplina dsp1 = new Disciplina(null, "Matemática", "MAT", 180);
		Disciplina dsp2 = new Disciplina(null, "Geografia", "GEO", 140);
		Disciplina dsp3 = new Disciplina(null, "História", "HIS", 120);
		Disciplina dsp4 = new Disciplina(null, "Química", "QUI", 80);
		Disciplina dsp5 = new Disciplina(null, "Artes", "ART", 280);
		
		repositoryDsp.saveAll(Arrays.asList(dsp1, dsp2, dsp3, dsp4, dsp5));
		
	}

}
