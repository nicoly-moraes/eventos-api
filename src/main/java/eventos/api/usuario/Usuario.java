package eventos.api.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name="usuarios")
@Entity(name="Usuario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long cpf;
    private String email;
    private String senha;

    public Usuario(DadosCadastrarUsuario dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.senha = dados.senha();
    }
}
