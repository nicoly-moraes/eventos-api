package eventos.api.endereco;

import jakarta.persistence.*;
import lombok.*;

@Table(name="enderecos")
@Entity(name="Endereco")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descricao;

    private int cep;

    private String logradouro;

    private int numero;

    private String complemento;

    private String cidade;

    private String uf;

    public Endereco(DadosEndereco dados) {
        this.descricao = dados.descricao();
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if(dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if(dados.numero() != 0) {
            this.numero = dados.numero();
        }
        if(dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if(dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if(dados.uf() != null) {
            this.uf = dados.uf();
        }
    }
}
