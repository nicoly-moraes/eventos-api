package eventos.api.evento;

import eventos.api.endereco.DadosEndereco;

public record DadosAtualizarEvento(
        String nome,
        String data,
        String img,
        String capa,
        String sobre,
        DadosEndereco endereco) {
}
