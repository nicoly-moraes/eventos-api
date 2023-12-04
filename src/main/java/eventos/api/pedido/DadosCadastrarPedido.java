package eventos.api.pedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarPedido(
        @NotNull
        Long usuario_id,
        @NotNull
        Long ingresso_id,
        @NotBlank
        String data,
        @NotNull
        int status,
        @NotNull
        int tipoPagamento) {
}
