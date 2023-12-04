package eventos.api.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarUsuario(
        @NotBlank
        String nome,
        @NotNull
        Long cpf,
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
