package eventos.api.controller;

import eventos.api.evento.*;
import eventos.api.evento.DadosAtualizarEvento;
import eventos.api.evento.Evento;
import eventos.api.evento.EventoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService service;

    @GetMapping
    public List<DadosListarEvento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Evento> listarId(@PathVariable Long id) {
        return service.listarId(id);
    }

    @PostMapping
    @Transactional
    public Evento cadastrar(@RequestBody @Valid DadosCadastrarEvento dados) {
        return service.cadastrar(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public Evento atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarEvento dados) {
        return service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}