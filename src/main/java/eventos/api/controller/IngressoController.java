package eventos.api.controller;

import eventos.api.ingresso.*;
import eventos.api.ingresso.Ingresso;
import eventos.api.ingresso.IngressoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {
    @Autowired
    private IngressoService service;

    @GetMapping
    public List<DadosListarIngresso> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Ingresso> listarId(@PathVariable Long id) {
        return service.listarId(id);
    }

    @PostMapping
    @Transactional
    public Ingresso cadastrar(@RequestBody @Valid DadosCadastrarIngresso dados) {
        return service.cadastrar(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public Ingresso atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarIngresso dados) {
        return service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
