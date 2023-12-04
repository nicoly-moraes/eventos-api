package eventos.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEndereco(
        @NotBlank
        String descricao,

        @NotNull
        int cep,

        @NotBlank
        String logradouro,

        int numero,

        String complemento,

        @NotBlank
        String cidade,

        @NotBlank
        String uf ) {
}
