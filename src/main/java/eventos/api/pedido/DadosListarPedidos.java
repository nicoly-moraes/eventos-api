package eventos.api.pedido;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor()
@Getter()
@JsonSerialize()
public class DadosListarPedidos {
    private Long id;
    private String nomeUsuario;
    private String nomeIngresso;
    private String nomeSetor;
    private String nomeEvento;
    private String data;
}