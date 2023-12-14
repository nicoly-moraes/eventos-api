package eventos.api.setor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public List<DadosListarSetor> listar(Long evento_id) {
        if (evento_id != 0) {
            return setorRepository.findAllByEventoId(evento_id)
                .stream()
                .map(DadosListarSetor::new)
                .toList();
        }

        return setorRepository
                .findAll()
                .stream()
                .map(DadosListarSetor::new)
                .toList();
    }

    public Optional<Setor> listarId(Long id) {
        return setorRepository.findById(id);
    }

    public Setor cadastrar(DadosCadastrarSetor dados) {
        Setor setor = new Setor(dados);
        return setorRepository.save(setor);
    }

    public Setor atualizar(Long id, DadosAtualizarSetor dados) {
        var exiteSetor = setorRepository.existsById(id);
        if (exiteSetor) {
            var setor = setorRepository.getReferenceById(id);
            setor.atualizar(dados);
            return setorRepository.save(setor);
        }
        return null;
    }

    public void excluir(Long id) {
        setorRepository.deleteById(id);
    }
}
