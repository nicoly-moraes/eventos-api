package eventos.api.controller;

import eventos.api.pedido.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping
    public List<DadosListarPedidos> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> listarId(@PathVariable Long id) {
        return service.listarId(id);
    }

    @PostMapping
    @Transactional
    public Pedido cadastrar(@RequestBody @Valid DadosCadastrarPedido dados) {
        return service.cadastrar(dados);
    }
}
