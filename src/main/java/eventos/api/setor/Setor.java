package eventos.api.setor;

import jakarta.persistence.*;
import lombok.*;

@Table(name="setores")
@Entity(name="Setor")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long evento_id;

    private String nome;

    public Setor(DadosCadastrarSetor dados) {
        this.nome = dados.nome();
        this.evento_id = dados.evento_id();
    }

    public void atualizar(DadosAtualizarSetor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
}
