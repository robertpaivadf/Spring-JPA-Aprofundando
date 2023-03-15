package https.github.com.robertpaivadf.localizacao;

import https.github.com.robertpaivadf.localizacao.domain.entity.CidadeEntity;
import https.github.com.robertpaivadf.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicializado.");
		salvarCidade();
		listarCidades();
	}

	@Transactional
	private void salvarCidade(){
		var cidade = new CidadeEntity(1L,"Gama",150000L);
		cidadeRepository.save(cidade);
		cidade = new CidadeEntity(2L,"Tagua",250000L);
		cidadeRepository.save(cidade);
		cidade = new CidadeEntity(3L,"Lago Azul",50000L);
		cidadeRepository.save(cidade);
	}

	private void listarCidades(){
		System.out.println("------------------------- RESULTADOS ----------------------------");
		System.out.println();

		System.out.println();System.out.println("findAll");
		cidadeRepository.findAll().forEach(System.out::println);
		System.out.println();System.out.println("findByNomeLike");
		cidadeRepository.findByNomeLike("%zul%").forEach(System.out::println);
		System.out.println();System.out.println("findByNomeLike2");
		cidadeRepository.findByNomeLike2("%gama%").forEach(System.out::println);
		System.out.println();System.out.println("findByHabitantesLessThan");
		cidadeRepository.findByQtdHabitantesLessThan(60000L).forEach(System.out::println);

		System.out.println();System.out.println("findByQtdHabitantesLessThanAndNomeLike");
		cidadeRepository.findByQtdHabitantesLessThanAndNomeLike(60000L, "La%").forEach(System.out::println);

		System.out.println();
		System.out.println("------------------------- RESULTADOS ----------------------------");

	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
