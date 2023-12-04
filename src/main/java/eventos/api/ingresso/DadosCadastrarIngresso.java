package eventos.api.ingresso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarIngresso(
        @NotNull
        Long setor_id,
        @NotBlank
        String nome,
        @NotNull
        Double valor,
        @NotNull
        int qtdLimite) {
}
