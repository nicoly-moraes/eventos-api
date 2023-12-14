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
}
