package eventos.api.evento;

import eventos.api.endereco.Endereco;
import eventos.api.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<DadosListarEvento> listar() {
        return eventoRepository.findAll()
                .stream()
                .map(DadosListarEvento::new)
                .toList();
    }

    public Optional<Evento> listarId(Long id) {
        return eventoRepository.findById(id);
    }

    public Evento cadastrar(DadosCadastrarEvento dados) {
        Endereco endereco = enderecoRepository.save(new Endereco(dados.endereco()));
        Evento evento = new Evento(dados);
        evento.setEndereco(endereco);
        return eventoRepository.save(evento);
    }

    public Evento atualizar(Long id, DadosAtualizarEvento dados) {
        var exiteEvento = eventoRepository.existsById(id);
        if (exiteEvento) {
            var evento = eventoRepository.getReferenceById(id);
            evento.atualizar(dados);
            return eventoRepository.save(evento);
        }
        return null;
    }

    public void excluir(Long id) {
        eventoRepository.deleteById(id);
    }
}
