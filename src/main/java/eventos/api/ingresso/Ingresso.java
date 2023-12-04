package eventos.api.ingresso;

import jakarta.persistence.*;
import lombok.*;

@Table(name="ingressos")
@Entity(name="Ingresso")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Double valor;
    private int qtdLimite;
    private Long setor_id;

    public Ingresso(DadosCadastrarIngresso dados) {
        this.nome = dados.nome();
        this.valor = dados.valor();
        this.qtdLimite = dados.qtdLimite();
        this.setor_id = dados.setor_id();
    }

    public void atualizar(DadosAtualizarIngresso dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.valor() != null) {
            this.valor = dados.valor();
        }
        if(dados.qtdLimite() != 0) {
            this.qtdLimite = dados.qtdLimite();
        }
    }
}
