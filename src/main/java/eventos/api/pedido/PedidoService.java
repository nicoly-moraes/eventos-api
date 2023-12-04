package eventos.api.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<DadosListarPedido> listar() {
        return pedidoRepository.findAll()
                .stream()
                .map(DadosListarPedido::new)
                .toList();
    }

    public Optional<Pedido> listarId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido cadastrar(DadosCadastrarPedido dados) {
        Pedido pedido = new Pedido(dados);
        return pedidoRepository.save(pedido);
    }
}
