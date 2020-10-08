package br.com.escola.projeto.techfin.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.escola.projeto.techfin.entities.Aluno;
import br.com.escola.projeto.techfin.entities.Disciplina;
import br.com.escola.projeto.techfin.entities.Pessoa;
import br.com.escola.projeto.techfin.entities.Professor;
import br.com.escola.projeto.techfin.entities.Turma;
import br.com.escola.projeto.techfin.respositories.AlunoRepository;
import br.com.escola.projeto.techfin.respositories.DisciplinaRepository;
import br.com.escola.projeto.techfin.respositories.ProfessorRepository;
import br.com.escola.projeto.techfin.respositories.TurmaRepository;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner{

	@Autowired
	DisciplinaRepository repositoryDisciplina;
	
	@Autowired
	ProfessorRepository repositoryProfessor;
	
	@Autowired
	AlunoRepository repositoryAluno;
	
	@Autowired
	TurmaRepository repositoryTurma;
		
	@Override
	public void run(String... args) throws Exception {
		
		Professor prof1 = new Professor(null, "Antônio Augusto", "antonio.augusto@gmail.com", "295.096.418-47", "MBA");
		Professor prof2 = new Professor(null, "Maria Clara", "maria.clara@gmail.com", "295.096.418-47", "Doutor");
		Professor prof3 = new Professor(null, "João Lucas", "joao.lucas@gmail.com", "295.096.418-47", "MBA/PhD");		
		Professor prof4 = new Professor(null, "Ana Carolina", "ana.carolina@gmail.com", "295.096.418-47", "PhD");
				
		repositoryProfessor.saveAll(Arrays.asList(prof1,prof2,prof3,prof4));
				
		Disciplina dsp1 = new Disciplina(null, "Matemática", "MAT", 180, prof1);
		Disciplina dsp2 = new Disciplina(null, "Geografia", "GEO", 140, prof2);
		Disciplina dsp3 = new Disciplina(null, "História", "HIS", 120, prof1);
		Disciplina dsp4 = new Disciplina(null, "Química", "QUI", 80, prof1);
		Disciplina dsp5 = new Disciplina(null, "Artes", "ART", 280, prof3);
		Disciplina dsp6 = new Disciplina(null, "Ed. Física", "EDF", 280, prof4);
		
		repositoryDisciplina.saveAll(Arrays.asList(dsp1, dsp2, dsp3, dsp4, dsp5, dsp6));
			
		Aluno al1 = new Aluno(null, "Willian Moraes", "willian.cunha@totvs.com.br", "295.096.418-47", "0001", "ENAD");
		Aluno al2 = new Aluno(null, "Thiago Leite", "thiago.leite@totvs.com.br", "295.096.418-47", "0002", "ENAD");
		Aluno al3 = new Aluno(null, "Victória Durães", "victoria.duraes@totvs.com.br", "295.096.418-47", "0003", "ENAD");
		Aluno al4 = new Aluno(null, "Gerson Teixeira", "gerson.teixeira@totvs.com.br", "295.096.418-47", "0004", "ENAD");
		Aluno al5 = new Aluno(null, "Rubens Gomes", "rubens.gomes@totvs.com.br", "295.096.418-47", "0005", "ENEM");
		Aluno al6 = new Aluno(null, "Andressa Araújo", "andressa.araujo@totvs.com.br", "295.096.418-47", "0006", "ENEM");
		Aluno al7 = new Aluno(null, "Pedro Santos", "pedro.santos@totvs.com.br", "295.096.418-47", "0007", "ENAD");
		Aluno al8 = new Aluno(null, "Paulo Silva", "paulo.silva@totvs.com.br", "295.096.418-47", "0008", "ENEM");
		Aluno al9 = new Aluno(null, "Ivan Issa", "ivan.issa@totvs.com.br", "295.096.418-47", "0009", "ENAD");			
		
		repositoryAluno.saveAll(Arrays.asList(al1,al2,al3,al4,al5,al6,al7,al8, al9));
		
		Turma t1 = new Turma(null, dsp1.getNome(), 2020, 2020, 50, dsp1);				
		repositoryTurma.saveAll(Arrays.asList(t1));
		
		t1.getAlunos().addAll(Arrays.asList(al1, al8, al5));				
		repositoryTurma.saveAll(Arrays.asList(t1));
		
		
				
	}

}
