package https.github.com.robertpaivadf.localizacao.service;

import https.github.com.robertpaivadf.localizacao.domain.repository.CidadeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    public void listarCidadesPorNome(){
        repository.findByNomeLike("%La%", Sort.by("qtdHabitantes", "nome")).forEach(System.out::println);
    }


}
