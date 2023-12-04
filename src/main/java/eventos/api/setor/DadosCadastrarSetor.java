package eventos.api.setor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarSetor(
        @NotBlank
        String nome,
        @NotNull
        Long evento_id) {
}
