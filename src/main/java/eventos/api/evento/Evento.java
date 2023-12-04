package eventos.api.evento;

import eventos.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name="eventos")
@Entity(name="Evento")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String data;

    private String img;

    private String capa;

    private String sobre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    public Evento(DadosCadastrarEvento dados) {
        this.nome = dados.nome();
        this.data = dados.data();
        this.img = dados.img();
        this.capa = dados.capa();
        this.sobre = dados.sobre();
    }

    public void atualizar(DadosAtualizarEvento dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.data() != null) {
            this.data = dados.data();
        }
        if(dados.img() != null) {
            this.img = dados.img();
        }
        if(dados.capa() != null) {
            this.capa = dados.capa();
        }
        if(dados.sobre() != null) {
            this.sobre = dados.sobre();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

}
