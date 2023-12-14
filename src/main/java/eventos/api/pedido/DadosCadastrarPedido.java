package eventos.api.pedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarPedido(
        @NotNull
        Long cpf_usuario,

        @NotNull
        String nome_usuario,
        @NotNull
        Long ingresso_id) {
}
