package eventos.api.ingresso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IngressoService {
    @Autowired
    private IngressoRepository ingressoRepository;

    public List<DadosListarIngresso> listar(Long setor_id) {
        if (setor_id != 0) {
            return ingressoRepository.findAllBySetorId(setor_id)
                    .stream()
                    .map(DadosListarIngresso::new)
                    .toList();
        }
        return ingressoRepository
                .findAll()
                .stream()
                .map(DadosListarIngresso::new)
                .toList();
    }

    public Optional<Ingresso> listarId(Long id) {
        return ingressoRepository.findById(id);
    }

    public Ingresso cadastrar(DadosCadastrarIngresso dados) {
        Ingresso ingresso = new Ingresso(dados);
        return ingressoRepository.save(ingresso);
    }

    public Ingresso atualizar(Long id, DadosAtualizarIngresso dados) {
        var exiteIngresso = ingressoRepository.existsById(id);
        if (exiteIngresso) {
            var ingresso = ingressoRepository.getReferenceById(id);
            ingresso.atualizar(dados);
            return ingressoRepository.save(ingresso);
        }
        return null;
    }

    public void excluir(Long id) {
        ingressoRepository.deleteById(id);
    }
}
