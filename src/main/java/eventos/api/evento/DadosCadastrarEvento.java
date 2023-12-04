package eventos.api.evento;
import eventos.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarEvento(
        @NotBlank
        String nome,

        @NotBlank
        String data,

        @NotBlank
        String img,

        @NotBlank
        String capa,

        String sobre,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
