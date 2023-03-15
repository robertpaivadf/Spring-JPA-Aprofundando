package https.github.com.robertpaivadf.localizacao.domain.repository;

import https.github.com.robertpaivadf.localizacao.domain.entity.CidadeEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {

    List<CidadeEntity> findByNomeLike(String nome, Sort sort);

    @Query(" select c from CidadeEntity c where upper(c.nome) like upper(?1) ")
    List<CidadeEntity> findByNomeLike2(String nome);


    List<CidadeEntity> findByQtdHabitantes(Long qtdHabitantes);

    List<CidadeEntity> findByQtdHabitantesLessThan(Long qtdHabitantes);

    List<CidadeEntity> findByQtdHabitantesLessThanAndNomeLike(Long qtdHabitantes, String nome);


}
