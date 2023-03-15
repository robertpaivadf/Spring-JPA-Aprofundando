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
	}

	private void listarCidades(){
		cidadeRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
