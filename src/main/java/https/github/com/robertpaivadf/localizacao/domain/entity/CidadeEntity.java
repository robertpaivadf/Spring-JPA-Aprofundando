package https.github.com.robertpaivadf.localizacao.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_CIDADE")
public class CidadeEntity {

        @Id
        private Long idCidade;

        @Column(name="nome", length = 50)
        private String nome;
        private Long qtdHabitantes;

}
