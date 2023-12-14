package eventos.api.pedido;

import eventos.api.evento.EventoRepository;
import eventos.api.ingresso.IngressoRepository;
import eventos.api.setor.SetorRepository;
import eventos.api.usuario.Usuario;
import eventos.api.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IngressoRepository ingressoRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<DadosListarPedidos> listar() {
        var pedidos = pedidoRepository.findAll();

        List<DadosListarPedidos> dados = new ArrayList<>();

        for (int i = 0; i < pedidos.size(); i++) {
            Long usuarioId = pedidos.get(i).getUsuario_id();
            var usuario = this.usuarioRepository.findById(usuarioId).get();

            Long ingressoId = pedidos.get(i).getIngresso_id();
            var ingresso = this.ingressoRepository.findById(ingressoId).get();

            Long setorId = ingresso.getSetor_id();
            var setor = this.setorRepository.findById(setorId).get();

            Long eventoId = setor.getEvento_id();
            var evento = this.eventoRepository.findById(eventoId).get();

            dados.add(new DadosListarPedidos(
                    pedidos.get(i).getId(),
                    usuario.getNome(),
                    ingresso.getNome(),
                    setor.getNome(),
                    evento.getNome(),
                    pedidos.get(i).getData()
            ));
        }

        return dados;
    }

    public Optional<Pedido> listarId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido cadastrar(DadosCadastrarPedido dados) {
        Pedido pedido = new Pedido();
        pedido.setIngresso_id(dados.ingresso_id());
        pedido.setData(LocalDateTime.now().toString());
        var usuario = this.usuarioRepository.findAllByCpf(dados.cpf_usuario());
        if (usuario.isPresent()) {
            pedido.setUsuario_id(usuario.get().getId());
        } else {
            Usuario novoUsuario = new Usuario();
            novoUsuario.setCpf(dados.cpf_usuario());
            novoUsuario.setNome(dados.nome_usuario());
            novoUsuario = this.usuarioRepository.save(novoUsuario);
            pedido.setUsuario_id(novoUsuario.getId());
        }
        return pedidoRepository.save(pedido);
    }
}
