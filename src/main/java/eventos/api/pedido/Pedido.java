package eventos.api.pedido;

import jakarta.persistence.*;
import lombok.*;

@Table(name="pedidos")
@Entity(name="Pedido")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuario_id;
    private Long ingresso_id;
    private String data;
    private int status;
    private int tipoPagamento;

    public Pedido(DadosCadastrarPedido dados) {
        this.usuario_id = dados.usuario_id();
        this.ingresso_id = dados.ingresso_id();
        this.data = dados.data();
        this.status = dados.status();
        this.tipoPagamento = dados.tipoPagamento();
    }
}
