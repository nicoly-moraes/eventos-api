package eventos.api.evento;

import eventos.api.endereco.Endereco;

public record DadosListarEvento(Long id, String nome, String data, String img, String capa, String sobre, Endereco endereco) {

    public DadosListarEvento(Evento evento) {
        this(evento.getId(), evento.getNome(), evento.getData(), evento.getImg(), evento.getCapa(), evento.getSobre(), evento.getEndereco());
    }
}
